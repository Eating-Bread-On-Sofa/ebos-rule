package cn.edu.bjtu.ebosrule.entity;

import cn.edu.bjtu.ebosrule.controller.TerminalDataController;
import cn.edu.bjtu.ebosrule.controller.WebDataController;
import lombok.Data;

@Data

public class Terminal {

    private int flag = 0;

    private int drools_threshold1;
    private String drools_parameterName1;
    private String drools_symbol1;
    private String drools_operation1;

    public int getDrools_threshold1() {
        return drools_threshold1;
    }
    public int setDrools_threshold1(int num) { drools_threshold1=num; return drools_threshold1;}
    public String getDrools_parameterName1() {
        return drools_parameterName1;
    }
    public String setDrools_parameterName1(String str) { drools_parameterName1=str; return drools_parameterName1;}
    public String getDrools_symbol1() {
        return drools_symbol1;
    }
    public String setDrools_symbol1(String str) { drools_symbol1=str; return drools_symbol1;}
    public String getDrools_operation1() {
        return drools_operation1;
    }
    public String setDrools_operation1(String str) { drools_operation1=str; return drools_operation1;}


    int terminal_value_temp=TerminalDataController.value_temp;
    int terminal_value_wet=TerminalDataController.value_wet;
    String terminal_name=TerminalDataController.name;

    public int getFlag() {
        return flag;
    }
    public int setFlag(int num) { flag=num; return flag;}
}