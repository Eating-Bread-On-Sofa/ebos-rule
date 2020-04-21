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
    @GetMapping("/getRules")
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
                logService.info("添加新规则"+rule.getRuleName());
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

    @CrossOrigin
    @GetMapping("/getFormInfo")
    public JSONArray getFormInfo(){
        JSONArray ja = new JSONArray();
        JSONObject j=new JSONObject();
        j.put("value","第一个");
        ja.add(j);
        j=new JSONObject();
        j.put("value","第二个");
        ja.add(j);
        j=new JSONObject();
        j.put("value","第三个");
        ja.add(j);
        System.out.println(ja);
        return ja;
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

            for (int x = 0; x<10; x++)
                if(WebDataController.parameterName[x] == null)
                {
                    WebDataController.parameterName[x] = name;
                    WebDataController.threshold[x] = threshold;
                    WebDataController.symbol[x] = symbol;
                    WebDataController.operation[x] = operation;
                    WebDataController.service[x] = service;
                    WebDataController.ruleName[x] = ruleName;
                    break;
                }
        }
    }

}