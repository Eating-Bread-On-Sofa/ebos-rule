package cn.edu.bjtu.ebosrule.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.*;

import javax.jms.ConnectionFactory;

@RequestMapping("/api")
@RestController

public class WebDataController {

    public static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

    public static String parameterName;
    public static int threshold;
    public static String symbol;
    public static String operation;
    public static String service;

    @CrossOrigin
    @PostMapping("/webdata")
    public String Webdata(@RequestBody JSONObject info){

        int threshold = info.getIntValue("ruleParaThreshold");
        String name = info.getString("rulePara");
        String symbol = info.getString("ruleJudge");
        String operation = info.getString("ruleExecute");
        String service = info.getString("service");

        this.parameterName=name;
        this.threshold=threshold;
        this.symbol=symbol;
        this.operation=operation;
        this.service=service;
        //Test();
        return service;
    }

}
