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
            j.put("otherRules",ruleService.findAllRule().get(i).getOtherRules());
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
                logService.info("create","添加新规则"+rule.getRulePara()+rule.getRuleJudge()+rule.getRuleParaThreshold());
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
            JSONArray otherRules = j.getJSONArray("otherRules");

            WebDataController.parameterName[i] = name;
            WebDataController.threshold[i] = threshold;
            WebDataController.symbol[i] = symbol;
            WebDataController.operation[i] = operation;
            WebDataController.service[i] = service;
            WebDataController.ruleName[i] = ruleName;
            WebDataController.device[i] = device;
            WebDataController.scenario[i] = scenario;

            int otherRulesLen = otherRules.size();
            WebDataController.otherDevice = new String [10][otherRulesLen];
            WebDataController.otherSymbol = new String [10][otherRulesLen];
            WebDataController.otherThreshold = new int [10][otherRulesLen];
            WebDataController.otherLogic = new String [10][otherRulesLen];
            WebDataController.otherParameterName = new String [10][otherRulesLen];
            for(int k=0; k<otherRulesLen; k++) {
                WebDataController.otherDevice[i][k] = otherRules.getJSONObject(k).getString("device");
                WebDataController.otherSymbol[i][k] = otherRules.getJSONObject(k).getString("ruleJudge");
                WebDataController.otherThreshold[i][k] = otherRules.getJSONObject(k).getIntValue("ruleParaThreshold");
                WebDataController.otherLogic[i][k] = otherRules.getJSONObject(k).getString("logic");
                WebDataController.otherParameterName[i][k] = otherRules.getJSONObject(k).getString("parameter");
            }
        }
    }

    @CrossOrigin
    @RequestMapping ("/logtest")
    public String logTest(){
        logService.debug("create","gwinst1");
        logService.info("delete","gwinst2");
        logService.warn("update","gwinst3");
        logService.error("retrieve","gwinst4");
        logService.debug("retrieve","增");
        logService.info("update","删");
        logService.warn("delete","改");
        logService.error("create","查");
        return "成功";
    }

    @CrossOrigin
    @GetMapping("/logtest")
    public JSONArray loggerTest(){
        return logService.findAll();
    }

}