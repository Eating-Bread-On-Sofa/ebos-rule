package cn.edu.bjtu.ebosrule.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController

public class WebDataController {

    public static String [] parameterName = new String[10];
    public static int [] threshold= new int [10];
    public static String [] symbol= new String[10];
    public static String [] operation= new String[10];
    public static String [] service= new String[10];
    public static String [] ruleName= new String[10];
    public static String [] device= new String[10];
    public static String [] device2= new String[10];
    public static String [] device3= new String[10];
    public static String [] scenario= new String[10];
    public static String [] parameterName2 = new String[10];
    public static int [] threshold2= new int [10];
    public static String [] symbol2= new String[10];
    public static String [] parameterName3 = new String[10];
    public static int [] threshold3= new int [10];
    public static String [] symbol3= new String[10];

    @CrossOrigin
    @PostMapping("/webdata")
    public String Webdata(@RequestBody JSONObject info){
        int threshold = info.getIntValue("ruleParaThreshold");
        String name = info.getString("rulePara");
        String symbol = info.getString("ruleJudge");
        String operation = info.getString("ruleExecute");
        String service = info.getString("service");
        String ruleName = info.getString("ruleName");
        String device = info.getString("device");
        String device2 = info.getString("device2");
        String device3 = info.getString("device3");
        String scenario = info.getString("scenario");
        int threshold2 = info.getIntValue("ruleParaThreshold2");
        String name2 = info.getString("rulePara2");
        String symbol2 = info.getString("ruleJudge2");
        int threshold3 = info.getIntValue("ruleParaThreshold3");
        String name3 = info.getString("rulePara3");
        String symbol3 = info.getString("ruleJudge3");

        for (int i = 0; i<10; i++)
            if (this.parameterName[i] == null)
            {
                this.parameterName[i] = name;
                this.threshold[i] = threshold;
                this.symbol[i] = symbol;
                this.operation[i] = operation;
                this.service[i] = service;
                this.ruleName[i] = ruleName;
                this.device[i] = device;
                this.device2[i] = device2;
                this.device3[i] = device3;
                this.scenario[i] = scenario;
                this.parameterName2[i] = name2;
                this.threshold2[i] = threshold2;
                this.symbol2[i] = symbol2;
                this.parameterName3[i] = name3;
                this.threshold3[i] = threshold3;
                this.symbol3[i] = symbol3;
                break;
            }
        return "收到前端数据";
    }
}