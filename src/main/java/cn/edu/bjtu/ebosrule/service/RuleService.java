package cn.edu.bjtu.ebosrule.service;

import cn.edu.bjtu.ebosrule.entity.Rule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RuleService {
    public Page<Rule> findAllRule(Pageable pageable);
    public List<Rule> findAllRule();
    public boolean addRule(Rule rule);
    public String deleteRule(String ruleId);
    public Rule findRuleByRuleId(String ruleId);
//    public Page<Rule> findRuleByRuleToDevice(String ruleToDevice, Pageable pageable);
    public void changeRuleStatus(Rule rule, int status);
}
