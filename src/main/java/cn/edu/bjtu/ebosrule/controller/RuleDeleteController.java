package cn.edu.bjtu.ebosrule.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController

public class RuleDeleteController {

    public static String [] ruleName= new String[10];

    @CrossOrigin
    @PostMapping("/ruleDelete")

    public void ruleDelete(@RequestBody JSONObject info)
    {
        String ruleName = info.getString("ruleName");

        for (int i = 0; i<10; i++) {
            if((WebDataController.ruleName[i])!=null) {
                if ((WebDataController.ruleName[i]).equals(ruleName)) {
                    WebDataController.parameterName[i] = null;
                    WebDataController.threshold[i] = 0;
                    WebDataController.symbol[i] = null;
                    WebDataController.operation[i] = null;
                    WebDataController.service[i] = null;
                    break;
                }
            }
            else
                continue;
        }
    }
}
