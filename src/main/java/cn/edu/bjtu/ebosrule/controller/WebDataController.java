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

    @CrossOrigin
    @PostMapping("/webdata")
    public void Webdata(@RequestBody JSONObject info){
        int threshold = info.getIntValue("ruleParaThreshold");
        String name = info.getString("rulePara");
        String symbol = info.getString("ruleJudge");
        String operation = info.getString("ruleExecute");
        String service = info.getString("service");
        String ruleName = info.getString("ruleName");
        for (int i = 0; i<10; i++)
            if (this.parameterName[i] == null)
            {
                this.parameterName[i] = name;
                this.threshold[i] = threshold;
                this.symbol[i] = symbol;
                this.operation[i] = operation;
                this.service[i] = service;
                this.ruleName[i] = ruleName;
                break;
            }
    }
}