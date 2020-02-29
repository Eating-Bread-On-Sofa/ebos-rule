package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.dao.RuleRepository;
import cn.edu.bjtu.ebosrule.entity.Rule;
import cn.edu.bjtu.ebosrule.service.LogService;
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

    @CrossOrigin
    @GetMapping("/rules")
    public LayuiTableResultUtil<List<Rule>> Rules(@RequestParam Integer page, @RequestParam Integer limit) {
        Pageable pageable = PageRequest.of(page-1, limit);
        Page<Rule> rules =  ruleService.findAllRule(pageable);
        LayuiTableResultUtil<List<Rule>> rulesTable=new LayuiTableResultUtil<List<Rule>>("",rules.getContent(),0,(int)rules.getTotalElements());
        return rulesTable;
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
        // System.out.println(rule.getRuleId());
        String deleteStatus = ruleService.deleteRule(rule.getRuleId());
        return  new LayuiTableResultUtil<String>("",deleteStatus,0,1);
    }
    @CrossOrigin
    @RequestMapping ("/logtest")
    public String logtest1(){
        logService.info("rule");
        return "成功";
    }
    @CrossOrigin
    @GetMapping("/logtest")
    public String logtest2(){
        return logService.findLogByCategory("info");
    }
}
