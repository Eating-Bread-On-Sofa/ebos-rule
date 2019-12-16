package cn.edu.bjtu.ebosrule.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.edu.bjtu.ebosrule.entity.Terminal;
import cn.edu.bjtu.ebosrule.service.MqService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.*;

import javax.jms.ConnectionFactory;


@RequestMapping("/api")
@RestController

public class TerminalDataController {
    @Autowired
    MqService mqService;
    public static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

    public static String name;
    public static int value;

    @PostMapping("/terminaldata")
    @ResponseBody
    public String msgTest(@RequestBody JSONObject json1)
    {
        mqService.publish("rules_terminal",json1);
        return "发送成功";
    }

    @JmsListener(destination = "rules_terminal", containerFactory = "topicContainerFactory")
    public void Terminaldata( JSONObject info ){
        System.out.println("规则引擎收到消息"+info);
        JSONArray jsonarray = info.getJSONArray("readings");
        JSONObject jsonpacket= jsonarray.getJSONObject(0);
        int value = jsonpacket.getIntValue("value");
        String name = jsonpacket.getString("name");

        this.value=value;
        this.name=name;
        try{
        Test();}catch (Exception e){}
        System.out.println("传感器参数---"+value);
    }

    @Test
    public void Test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Terminal terminal = new Terminal();

        kieSession.insert(terminal);
        kieSession.fireAllRules();//通知规则引擎执行规则

        int flag1=terminal.getFlag1();
        int flag2=terminal.getFlag2();

        int OutThreshold=WebDataController.threshold;
        String OutName=" ";
        String OutSymbol=" ";
        {
            if(WebDataController.parameterName.equals("0")){OutName = "温度";}
            if(WebDataController.parameterName.equals("1")){OutName = "湿度";}
        }
        {
            if(WebDataController.symbol.equals("0")){OutSymbol = ">";}
            if(WebDataController.symbol.equals("1")){OutSymbol = "<";}
            if(WebDataController.symbol.equals("2")){OutSymbol = "=";}
        }

        if (flag1!=0 || flag2!=0)
        {
            System.out.println("输出条件为："+OutName+OutSymbol+OutThreshold);
            JSONObject alert = new JSONObject();
            alert.put("content",OutName+OutSymbol+OutThreshold+"!");
            mqService.publish("notice",alert);

            if (WebDataController.operation.equals("1"))
            {
                JSONObject json = new JSONObject();
                json.put("name",WebDataController.service);
                mqService.publish("run.command",json);
            }
        }

/*        String tem1="温度高了,";
        String tem2="温度低了,";
        String wet1="湿度高了,";
        String wet2="湿度高了,";
        String op=" ";
        if(WebDataController.operation.equals("0")){op="要进行警告";}
        if(WebDataController.operation.equals("1")){op="要关闭设备";}
        if(WebDataController.operation.equals("2")){op="要进行赋值";}
        if (flag1==1){
            System.out.println(tem1+op);
            JSONObject alert = new JSONObject();
            alert.put("content",tem1+op);
            mqService.publish("notice",alert);
        }
        if (flag1==2){
            System.out.println(tem2+op);
            JSONObject alert = new JSONObject();
            alert.put("content",tem2+op);
            mqService.publish("notice",alert);}
        if (flag2==1){
            System.out.println(wet1+op);
            JSONObject alert = new JSONObject();
            alert.put("content",wet1+op);
            mqService.publish("notice",alert);}
        if (flag2==2){
            System.out.println(wet2+op);
            JSONObject alert = new JSONObject();
            alert.put("content",wet2+op);
            mqService.publish("notice",alert);}*/
        kieSession.dispose();
    }

}
