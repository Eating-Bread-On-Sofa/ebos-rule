package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.service.LogService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.edu.bjtu.ebosrule.dao.RuleRepository;
import cn.edu.bjtu.ebosrule.entity.Rule;
import cn.edu.bjtu.ebosrule.service.RuleService;
import cn.edu.bjtu.ebosrule.util.LayuiTableResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RequestMapping("/api")
@RestController
public class RuleController {
    @Autowired
    RuleService ruleService;
    @Autowired
    RuleRepository ruleRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    LogService logService;
    @Value("${server.edgex}")
    private String ip;
    JSONArray ja = new JSONArray();

    @CrossOrigin
    @GetMapping("/rules")
    public LayuiTableResultUtil<List<Rule>> Rules(@RequestParam Integer page, @RequestParam Integer limit) {
        Pageable pageable = PageRequest.of(page-1, limit);
        Page<Rule> rules =  ruleService.findAllRule(pageable);
        LayuiTableResultUtil<List<Rule>> rulesTable=new LayuiTableResultUtil<List<Rule>>("",rules.getContent(),0,(int)rules.getTotalElements());
        return rulesTable;
    }

    @CrossOrigin
    @GetMapping("/getRuleLists")
    public JSONArray getRule(){
        JSONArray ja = new JSONArray();
        for (int i = 0; i < ruleService.findAllRule().size(); i++) {
            JSONObject j=new JSONObject();
            j.put("ruleName",ruleService.findAllRule().get(i).getRuleName());
            j.put("parameter",ruleService.findAllRule().get(i).getRulePara());
            j.put("ruleJudge",ruleService.findAllRule().get(i).getRuleJudge());
            j.put("threshold",ruleService.findAllRule().get(i).getRuleParaThreshold());
            j.put("ruleExecute",ruleService.findAllRule().get(i).getRuleExecute());
            j.put("ruleId",ruleService.findAllRule().get(i).getRuleId());
            j.put("service",ruleService.findAllRule().get(i).getService());
            j.put("device",ruleService.findAllRule().get(i).getDevice());
            j.put("scenario",ruleService.findAllRule().get(i).getScenario());
            j.put("parameter2",ruleService.findAllRule().get(i).getRulePara2());
            j.put("ruleJudge2",ruleService.findAllRule().get(i).getRuleJudge2());
            j.put("threshold2",ruleService.findAllRule().get(i).getRuleParaThreshold2());
            j.put("parameter3",ruleService.findAllRule().get(i).getRulePara3());
            j.put("ruleJudge3",ruleService.findAllRule().get(i).getRuleJudge3());
            j.put("threshold3",ruleService.findAllRule().get(i).getRuleParaThreshold3());
            ja.add(j);
        }
        this.ja=ja;
        this.loadRule();
        return ja;
    }

    @CrossOrigin
    @PostMapping("/ruleCreate")
    public Boolean addRule(@RequestBody Rule rule) {
        if (rule != null) {
            if (ruleService.addRule(rule)) {
                logService.info("添加新规则"+rule.getRulePara()+rule.getRuleJudge()+rule.getRuleParaThreshold());
                return true;
            }
        }
        return false;
    }

    @CrossOrigin
    @PostMapping("/rule")
    public LayuiTableResultUtil<String> deleteRule(@RequestBody Rule rule){
        String deleteStatus = ruleService.deleteRule(rule.getRuleId());
        return  new LayuiTableResultUtil<String>("",deleteStatus,0,1);
    }

    public void loadRule()
    {
        JSONArray ja = this.ja;

        for (int i = 0; i < ja.size(); i++)
        {
            JSONObject j = (JSONObject) ja.get(i);
            int threshold = j.getIntValue("threshold");
            String name = j.getString("parameter");
            String symbol = j.getString("ruleJudge");
            String operation = j.getString("ruleExecute");
            String service = j.getString("service");
            String ruleName = j.getString("ruleName");
            String device = j.getString("device");
            String scenario = j.getString("scenario");
            int threshold2 = j.getIntValue("threshold2");
            String name2 = j.getString("parameter2");
            String symbol2 = j.getString("ruleJudge2");
            int threshold3 = j.getIntValue("threshold3");
            String name3 = j.getString("parameter3");
            String symbol3 = j.getString("ruleJudge3");

            WebDataController.parameterName[i] = name;
            WebDataController.threshold[i] = threshold;
            WebDataController.symbol[i] = symbol;
            WebDataController.operation[i] = operation;
            WebDataController.service[i] = service;
            WebDataController.ruleName[i] = ruleName;
            WebDataController.device[i] = device;
            WebDataController.scenario[i] = scenario;
            WebDataController.parameterName2[i] = name2;
            WebDataController.threshold2[i] = threshold2;
            WebDataController.symbol2[i] = symbol2;
            WebDataController.parameterName3[i] = name3;
            WebDataController.threshold3[i] = threshold3;
            WebDataController.symbol3[i] = symbol3;
        }
    }

}