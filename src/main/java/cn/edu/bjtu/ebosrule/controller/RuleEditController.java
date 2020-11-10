package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.service.LogService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class RuleEditController {
    @Autowired
    LogService logService;
    public static String [] ruleName= new String[10];

    @CrossOrigin
    @PostMapping("/ruleEdit")

    public void ruleDelete(@RequestBody JSONObject info)
    {
        String ruleName = info.getString("ruleName");
        String parameterName = info.getString("parameterName");
        String operation = info.getString("operation");
        int threshold = info.getIntValue("threshold");
        String symbol = info.getString("symbol");
        String service = info.getString("service");
        System.out.println("修改："+ruleName);

        for (int i = 0; i<10; i++) {
            if((WebDataController.ruleName[i])!=null) {
                if ((WebDataController.ruleName[i]).equals(ruleName)) {
                    WebDataController.ruleName[i] = ruleName;
                    WebDataController.parameterName[i] = parameterName;
                    WebDataController.threshold[i] = threshold;
                    WebDataController.symbol[i] = symbol;
                    WebDataController.operation[i] = operation;
                    WebDataController.service[i] = service;
                    break;
                }
            }
            else
                continue;
        }
        logService.info("update","用户编辑规则："+ruleName);
    }
}
