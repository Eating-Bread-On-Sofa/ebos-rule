package cn.edu.bjtu.ebosrule.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Rule {
    @Id
    private String ruleId;
    private String ruleName;

    private String ruleDescribe;
    private Date ruleCreateTime;

    private int ruleParaThreshold;
    private String rulePara;
    private String ruleJudge;

    private int ruleParaThreshold2;
    private String rulePara2;
    private String ruleJudge2;

    private int ruleParaThreshold3;
    private String rulePara3;
    private String ruleJudge3;

    private String ruleToDevice;
    private String ruleToFunction;
    private int ruleStatus;
    private String ruleExecute;

    private String service;
    private String device;
    private String device2;
    private String device3;
    private String scenario;

    private String logic2;
    private String logic3;

    public String getLogic2() {
        return logic2;
    }
    public String getLogic3() {
        return logic3;
    }

    public String getService() {
        return service;
    }
    public String getDevice() { return device; }
    public String getDevice2() { return device2; }
    public String getDevice3() { return device3; }


    public String getScenario() { return scenario; }
    public void setService(String service) {
        this.service = service;
    }

    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getRuleParaThreshold() {
        return ruleParaThreshold;
    }
    public void setRuleParaThreshold(int ruleParaThreshold) {
        this.ruleParaThreshold = ruleParaThreshold;
    }
    public String getRulePara() {return rulePara;}
    public void setRulePara(String rulePara) {
        this.rulePara = rulePara;
    }
    public String getRuleJudge() { return ruleJudge; }
    public void setRuleJudge(String ruleJudge) {this.ruleJudge = ruleJudge; }
    public int getRuleParaThreshold2() {
        return ruleParaThreshold2;
    }
    public void setRuleParaThreshold2 (int ruleParaThreshold) {
        this.ruleParaThreshold2 = ruleParaThreshold;
    }
    public String getRulePara2() {return rulePara2;}
    public void setRulePara2(String rulePara) {
        this.rulePara2 = rulePara;
    }
    public String getRuleJudge2() { return ruleJudge2; }
    public void setRuleJudge2(String ruleJudge) {this.ruleJudge2 = ruleJudge; }
    public int getRuleParaThreshold3() { return ruleParaThreshold3;}
    public void setRuleParaThreshold3(int ruleParaThreshold) {
        this.ruleParaThreshold3 = ruleParaThreshold;
    }
    public String getRulePara3() {return rulePara3;}
    public void setRulePara3(String rulePara) {
        this.rulePara3 = rulePara;
    }
    public String getRuleJudge3() { return ruleJudge3; }
    public void setRuleJudge3(String ruleJudge) {this.ruleJudge3 = ruleJudge; }

    public String getRuleToDevice() {
        return ruleToDevice;
    }
    public void setRuleToDevice(String ruleToDevice) {
        this.ruleToDevice = ruleToDevice;
    }
    public String getRuleToFunction() {
        return ruleToFunction;
    }
    public void setRuleToFunction(String ruleToFunction) {
        this.ruleToFunction = ruleToFunction;
    }


    public int getRuleStatus() { return ruleStatus; }
    public void setRuleExecute(String ruleExecute) {this.ruleExecute = ruleExecute; }

    public String getRuleExecute() { return ruleExecute; }
    public void setRuleStatus(int ruleStatus) {this.ruleStatus = ruleStatus; }

    public String getRuleDescribe() {
        return ruleDescribe;
    }
    public void setRuleDescribe(String ruleDescribe) {
        this.ruleDescribe = ruleDescribe;
    }

    public Date getRuleCreateTime() {
        return ruleCreateTime;
    }
    public void setRuleCreateTime(Date ruleCreateTime) {
        this.ruleCreateTime = ruleCreateTime;
    }
}
