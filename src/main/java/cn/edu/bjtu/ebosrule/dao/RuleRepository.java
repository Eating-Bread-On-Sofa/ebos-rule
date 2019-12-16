package cn.edu.bjtu.ebosrule.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import cn.edu.bjtu.ebosrule.entity.Rule;

@Repository
public interface RuleRepository extends MongoRepository<Rule,String> {
    public Rule findRuleByRuleName(String ruleName);
    public Rule findRuleByRuleExecute(int ruleExecute);
    public Page<Rule> findAll(Pageable pageable);
    public Rule findRuleByRuleId(String ruleId);
}
