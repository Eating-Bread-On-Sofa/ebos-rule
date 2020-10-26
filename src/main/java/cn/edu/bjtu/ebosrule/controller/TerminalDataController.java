package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.service.MqFactory;
import cn.edu.bjtu.ebosrule.service.MqProducer;
import com.alibaba.fastjson.JSONObject;
import cn.edu.bjtu.ebosrule.entity.Terminal;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class TerminalDataController {
    @Autowired
    MqFactory mqFactory;

    public static String name;
    public static int value_temp;
    public static int value_wet;
    public static String device;
    public static int value;

    @CrossOrigin
    @PostMapping("/terminaldata")
    public String msgTest(@RequestBody JSONObject json1)
    {
        mqFactory.createProducer().publish("rules_terminal",json1.toString());
        return "发送成功";
    }

    @Test
    public void Test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Terminal terminal0 = new Terminal();
        Terminal terminal1 = new Terminal();
        Terminal terminal2 = new Terminal();
        Terminal terminal3 = new Terminal();
        Terminal terminal4 = new Terminal();
        Terminal terminal5 = new Terminal();
        Terminal terminal6 = new Terminal();
        Terminal terminal7 = new Terminal();
        Terminal terminal8 = new Terminal();
        Terminal terminal9 = new Terminal();

        terminalTemplate(terminal0,WebDataController.threshold[0],WebDataController.parameterName[0],WebDataController.symbol[0],WebDataController.operation[0],WebDataController.scenario[0],
                WebDataController.threshold2[0],WebDataController.parameterName2[0],WebDataController.symbol2[0],WebDataController.threshold3[0],WebDataController.parameterName3[0],WebDataController.symbol3[0]);
        terminalTemplate(terminal1,WebDataController.threshold[1],WebDataController.parameterName[1],WebDataController.symbol[1],WebDataController.operation[1],WebDataController.scenario[1],
                WebDataController.threshold2[1],WebDataController.parameterName2[1],WebDataController.symbol2[1],WebDataController.threshold3[1],WebDataController.parameterName3[1],WebDataController.symbol3[1]);
        terminalTemplate(terminal2,WebDataController.threshold[2],WebDataController.parameterName[2],WebDataController.symbol[2],WebDataController.operation[2],WebDataController.scenario[2],
                WebDataController.threshold2[2],WebDataController.parameterName2[2],WebDataController.symbol2[2],WebDataController.threshold3[2],WebDataController.parameterName3[2],WebDataController.symbol3[2]);
        terminalTemplate(terminal3,WebDataController.threshold[3],WebDataController.parameterName[3],WebDataController.symbol[3],WebDataController.operation[3],WebDataController.scenario[3],
                WebDataController.threshold2[3],WebDataController.parameterName2[3],WebDataController.symbol2[3],WebDataController.threshold3[3],WebDataController.parameterName3[3],WebDataController.symbol3[3]);
        terminalTemplate(terminal4,WebDataController.threshold[4],WebDataController.parameterName[4],WebDataController.symbol[4],WebDataController.operation[4],WebDataController.scenario[4],
                WebDataController.threshold2[4],WebDataController.parameterName2[4],WebDataController.symbol2[4],WebDataController.threshold3[4],WebDataController.parameterName3[4],WebDataController.symbol3[4]);
        terminalTemplate(terminal5,WebDataController.threshold[5],WebDataController.parameterName[5],WebDataController.symbol[5],WebDataController.operation[5],WebDataController.scenario[5],
                WebDataController.threshold2[5],WebDataController.parameterName2[5],WebDataController.symbol2[5],WebDataController.threshold3[5],WebDataController.parameterName3[5],WebDataController.symbol3[5]);
        terminalTemplate(terminal6,WebDataController.threshold[6],WebDataController.parameterName[6],WebDataController.symbol[6],WebDataController.operation[6],WebDataController.scenario[6],
                WebDataController.threshold2[6],WebDataController.parameterName2[6],WebDataController.symbol2[6],WebDataController.threshold3[6],WebDataController.parameterName3[6],WebDataController.symbol3[6]);
        terminalTemplate(terminal7,WebDataController.threshold[7],WebDataController.parameterName[7],WebDataController.symbol[7],WebDataController.operation[7],WebDataController.scenario[7],
                WebDataController.threshold2[7],WebDataController.parameterName2[7],WebDataController.symbol2[7],WebDataController.threshold3[7],WebDataController.parameterName3[7],WebDataController.symbol3[7]);
        terminalTemplate(terminal8,WebDataController.threshold[8],WebDataController.parameterName[8],WebDataController.symbol[8],WebDataController.operation[8],WebDataController.scenario[8],
                WebDataController.threshold2[8],WebDataController.parameterName2[8],WebDataController.symbol2[8],WebDataController.threshold3[8],WebDataController.parameterName3[8],WebDataController.symbol3[8]);
        terminalTemplate(terminal9,WebDataController.threshold[9],WebDataController.parameterName[9],WebDataController.symbol[9],WebDataController.operation[9],WebDataController.scenario[9],
                WebDataController.threshold2[9],WebDataController.parameterName2[9],WebDataController.symbol2[9],WebDataController.threshold3[9],WebDataController.parameterName3[9],WebDataController.symbol3[9]);
        kieSession.insert(terminal0);
        kieSession.insert(terminal1);
        kieSession.insert(terminal2);
        kieSession.insert(terminal3);
        kieSession.insert(terminal4);
        kieSession.insert(terminal5);
        kieSession.insert(terminal6);
        kieSession.insert(terminal7);
        kieSession.insert(terminal8);
        kieSession.insert(terminal9);

        kieSession.fireAllRules();//通知规则引擎执行规则

        int flag0=terminal0.getFlag();
        int flag1=terminal1.getFlag();
        int flag2=terminal2.getFlag();
        int flag3=terminal3.getFlag();
        int flag4=terminal4.getFlag();
        int flag5=terminal5.getFlag();
        int flag6=terminal6.getFlag();
        int flag7=terminal7.getFlag();
        int flag8=terminal8.getFlag();
        int flag9=terminal9.getFlag();

        ruleTemplate(0,WebDataController.gateway[0], WebDataController.ruleName[0],WebDataController.threshold[0],WebDataController.parameterName[0],WebDataController.symbol[0],WebDataController.operation[0],WebDataController.service[0],WebDataController.device[0],flag0,WebDataController.otherLogic[0],WebDataController.otherParameterName[0],WebDataController.otherSymbol[0],WebDataController.otherThreshold[0],WebDataController.otherDevice[0]);
        ruleTemplate(1,WebDataController.gateway[1], WebDataController.ruleName[1],WebDataController.threshold[1],WebDataController.parameterName[1],WebDataController.symbol[1],WebDataController.operation[1],WebDataController.service[1],WebDataController.device[1],flag1,WebDataController.otherLogic[1],WebDataController.otherParameterName[1],WebDataController.otherSymbol[1],WebDataController.otherThreshold[1],WebDataController.otherDevice[1]);
        ruleTemplate(2,WebDataController.gateway[2], WebDataController.ruleName[2],WebDataController.threshold[2],WebDataController.parameterName[2],WebDataController.symbol[2],WebDataController.operation[2],WebDataController.service[2],WebDataController.device[2],flag2,WebDataController.otherLogic[2],WebDataController.otherParameterName[2],WebDataController.otherSymbol[2],WebDataController.otherThreshold[2],WebDataController.otherDevice[2]);
        ruleTemplate(3,WebDataController.gateway[3], WebDataController.ruleName[3],WebDataController.threshold[3],WebDataController.parameterName[3],WebDataController.symbol[3],WebDataController.operation[3],WebDataController.service[3],WebDataController.device[3],flag3,WebDataController.otherLogic[3],WebDataController.otherParameterName[3],WebDataController.otherSymbol[3],WebDataController.otherThreshold[3],WebDataController.otherDevice[3]);
        ruleTemplate(4,WebDataController.gateway[4], WebDataController.ruleName[4],WebDataController.threshold[4],WebDataController.parameterName[4],WebDataController.symbol[4],WebDataController.operation[4],WebDataController.service[4],WebDataController.device[4],flag4,WebDataController.otherLogic[4],WebDataController.otherParameterName[4],WebDataController.otherSymbol[4],WebDataController.otherThreshold[4],WebDataController.otherDevice[4]);
        ruleTemplate(5,WebDataController.gateway[5], WebDataController.ruleName[5],WebDataController.threshold[5],WebDataController.parameterName[5],WebDataController.symbol[5],WebDataController.operation[5],WebDataController.service[5],WebDataController.device[5],flag5,WebDataController.otherLogic[5],WebDataController.otherParameterName[5],WebDataController.otherSymbol[5],WebDataController.otherThreshold[5],WebDataController.otherDevice[5]);
        ruleTemplate(6,WebDataController.gateway[6], WebDataController.ruleName[6],WebDataController.threshold[6],WebDataController.parameterName[6],WebDataController.symbol[6],WebDataController.operation[6],WebDataController.service[6],WebDataController.device[6],flag6,WebDataController.otherLogic[6],WebDataController.otherParameterName[6],WebDataController.otherSymbol[6],WebDataController.otherThreshold[6],WebDataController.otherDevice[6]);
        ruleTemplate(7,WebDataController.gateway[7], WebDataController.ruleName[7],WebDataController.threshold[7],WebDataController.parameterName[7],WebDataController.symbol[7],WebDataController.operation[7],WebDataController.service[7],WebDataController.device[7],flag7,WebDataController.otherLogic[7],WebDataController.otherParameterName[7],WebDataController.otherSymbol[7],WebDataController.otherThreshold[7],WebDataController.otherDevice[7]);
        ruleTemplate(8,WebDataController.gateway[8], WebDataController.ruleName[8],WebDataController.threshold[8],WebDataController.parameterName[8],WebDataController.symbol[8],WebDataController.operation[7],WebDataController.service[8],WebDataController.device[8],flag8,WebDataController.otherLogic[8],WebDataController.otherParameterName[8],WebDataController.otherSymbol[8],WebDataController.otherThreshold[8],WebDataController.otherDevice[8]);
        ruleTemplate(9,WebDataController.gateway[9], WebDataController.ruleName[9],WebDataController.threshold[9],WebDataController.parameterName[9],WebDataController.symbol[9],WebDataController.operation[8],WebDataController.service[9],WebDataController.device[9],flag9,WebDataController.otherLogic[9],WebDataController.otherParameterName[9],WebDataController.otherSymbol[9],WebDataController.otherThreshold[9],WebDataController.otherDevice[9]);

        kieSession.dispose();

        kieSession = null;

        terminal0 = null;
        terminal1 = null;
        terminal2 = null;
        terminal3 = null;
        terminal4 = null;
        terminal5 = null;
        terminal6 = null;
        terminal7 = null;
        terminal8 = null;
        terminal9 = null;
    }
    public void ruleTemplate (int index,String gateway, String ruleName,int OutThreshold,String name,String symbol,String operation,String service, String device, int flag1, String[] otherLogic, String[] otherParameterName, String[] otherSymbol, int[] otherThreshold, String[] otherDevice)
    {
        if(name==null)  return;
        String flagMsg = "";
        int Flag=0;
        int i=0;
        int len = otherDevice.length;
        int[] flag = new int [len];
        for( ; i<len; i++){
            if(otherParameterName[i]!=null && this.device.equals(otherDevice[i])){
                if(otherParameterName[i].equals("温度")){
                    if(otherSymbol[i].equals(">")){
                        if (this.value_temp>otherThreshold[i]){ flag[i] = 1;}
                    }
                    else if(otherSymbol[i].equals("<")){
                        if (this.value_temp<otherThreshold[i]){ flag[i] = 1; }
                    }
                }
                else if(otherParameterName[i].equals("湿度")){
                    if(otherSymbol[i].equals(">")){
                        if (this.value_wet>otherThreshold[i]){ flag[i] = 1; }
                    }
                    else if(otherSymbol[i].equals("<")){
                        if (this.value_wet<otherThreshold[i]){ flag[i] = 1; }
                    }
                }
            }
        }
        MqProducer mqProducer = mqFactory.createProducer();
        String content="";

        if(!this.device.equals(device)){ flag1=0; }

        if(flag1!=0){
            Flag=1;
        }
        for(int j=len-1; j>=0; j--){
            if(flag[j]!=0 && otherLogic[j].equals("或")){
                Flag=1;
            } else if(flag[j]==0 && otherLogic[j].equals("且")){
                Flag=0;
            }
        }

        if (Flag!=0) {
            System.out.println("--------------------------------------报警了--------------------------------------------");
            flagMsg += "第1个：" + flag1 + "---  ";
            if (flag1!=0){
                content+=device+name+symbol+OutThreshold+",";
            }
            for(int j=0; j<len; j++){
                flagMsg += "第" + (j+2) + "个：" + flag[j] + "---  ";
                if (flag[j]!=0){
                    content += otherParameterName[j]+otherSymbol[j]+otherThreshold[j]+",";
                }
            }
            content = gateway + ":" + content + "!";

            //放到日志中的alert消息
            JSONObject alert = new JSONObject();
            alert.put("type","alert");
            alert.put("message",content);
            alert.put("source",ruleName);

            flagMsg = null;

            if(operation.equals("告警") || operation.equals("告警且操作设备")){
                postController.sendPostRequest("http://localhost:8099/api/getMessage", alert);
                mqProducer.publish("notice",alert.toString());
                if(!RuleController.arrFlag[index]) {
                    RuleController.arrFlag[index] = true;
                    RuleController.arrMsg[index] = content;
                }
            }

            if (operation.equals("告警且操作设备") || operation.equals("操作设备"))
            {
                JSONObject json = new JSONObject();
                json.put("name",service);
                postController.sendPostRequest("http://localhost:8099/api/getCommand", json);
                mqProducer.publish("run.command",json.toString());
            }
        } else{
            RuleController.arrFlag[index] = false;
            RuleController.arrMsg[index] = "";
        }
    }
    public void terminalTemplate(Terminal t, int threshold1, String parameterName1, String symbol1, String operation, String scenario, int threshold2, String parameterName2, String symbol2, int threshold3, String parameterName3, String symbol3)
    {
        t.setDrools_threshold1(threshold1);
        t.setDrools_parameterName1(parameterName1);
        t.setDrools_symbol1(symbol1);
        t.setDrools_operation1(operation);
        t.setDrools_scenario1(scenario);
        t.setDrools_threshold2(threshold2);
        t.setDrools_parameterName2(parameterName2);
        t.setDrools_symbol2(symbol2);
        t.setDrools_threshold3(threshold3);
        t.setDrools_parameterName3(parameterName3);
        t.setDrools_symbol3(symbol3);
    }
}
