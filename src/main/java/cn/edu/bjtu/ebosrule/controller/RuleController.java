package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.service.Log;
import cn.edu.bjtu.ebosrule.service.LogFind;
import cn.edu.bjtu.ebosrule.service.impl.LogFindImpl;
import cn.edu.bjtu.ebosrule.service.log.LogImpl;
import com.alibaba.fastjson.JSON;
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
import com.alibaba.fastjson.serializer.SerializerFeature;


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
    Log log = new LogImpl();
    @Autowired
    LogFind logFind = new LogFindImpl();
    @Value("${server.edgex}")
    private String ip;


    @CrossOrigin
    @GetMapping("/rules")
    public LayuiTableResultUtil<List<Rule>> Rules(@RequestParam Integer page, @RequestParam Integer limit) {
        System.out.println("++++rules接口+++++");
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
            ja.add(j);
        }
        return ja;
    }

    @CrossOrigin
    @PostMapping("/ruleCreate")
    public Boolean addRule(@RequestBody Rule rule) {
        if (rule != null) {
            if (ruleService.addRule(rule)) {
                return true;
            }
        }
        return false;
    }

    @CrossOrigin
    @DeleteMapping("/rule")
    public LayuiTableResultUtil<String> deleteRule(@RequestBody Rule rule){
        String deleteStatus = ruleService.deleteRule(rule.getRuleId());
        return  new LayuiTableResultUtil<String>("",deleteStatus,0,1);
    }
    @CrossOrigin
    @RequestMapping ("/logtest")
    public String logtest1(){
        log.error("rule");
        return "成功";
    }
    @CrossOrigin
    @GetMapping("/logtest")
    public String logtest2(){
        return logFind.readAll();
    }
}
