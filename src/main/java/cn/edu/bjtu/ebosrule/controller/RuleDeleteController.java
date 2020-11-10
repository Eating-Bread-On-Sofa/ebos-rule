package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.service.LogService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class RuleDeleteController {
    @Autowired
    LogService logService;

    public static String [] ruleName= new String[10];

    @CrossOrigin
    @PostMapping("/ruleDelete")
    //清空内存中的数据
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
        logService.info("delete","成功删除规则:"+ruleName);
    }
}
