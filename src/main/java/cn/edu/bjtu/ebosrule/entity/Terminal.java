package cn.edu.bjtu.ebosrule.entity;

import cn.edu.bjtu.ebosrule.controller.TerminalDataController;
import lombok.Data;

@Data
public class Terminal {

    private int flag = 0;

    private int drools_threshold1;
    private String drools_parameterName1;
    private String drools_symbol1;
    private String drools_operation1;
    private String drools_scenario1;
    private int drools_threshold2;
    private String drools_parameterName2;
    private String drools_symbol2;
    private int drools_threshold3;
    private String drools_parameterName3;
    private String drools_symbol3;
    private String [] drools_symbol = new String[10];

    public int getDrools_threshold1() {
        return drools_threshold1;
    }
    public int setDrools_threshold1(int num) { drools_threshold1=num; return drools_threshold1;}
    public String getDrools_parameterName1() { return drools_parameterName1; }
    public String setDrools_parameterName1(String str) { drools_parameterName1=str; return drools_parameterName1;}
    public String getDrools_symbol1() {
        return drools_symbol1;
    }
    public String setDrools_symbol1(String str) { drools_symbol1=str; return drools_symbol1;}

    public int getDrools_threshold2() {
        return drools_threshold2;
    }
    public int setDrools_threshold2(int num) { drools_threshold2=num; return drools_threshold2;}
    public String getDrools_parameterName2() { return drools_parameterName2; }
    public String setDrools_parameterName2(String str) { drools_parameterName2=str; return drools_parameterName2;}
    public String getDrools_symbol2() {
        return drools_symbol2;
    }
    public String setDrools_symbol2(String str) { drools_symbol2=str; return drools_symbol2;}

    public int getDrools_threshold3() {
        return drools_threshold3;
    }
    public int setDrools_threshold3(int num) { drools_threshold3=num; return drools_threshold3;}
    public String getDrools_parameterName3() { return drools_parameterName3; }
    public String setDrools_parameterName3(String str) { drools_parameterName3=str; return drools_parameterName3;}
    public String getDrools_symbol3() {
        return drools_symbol1;
    }
    public String setDrools_symbol3(String str) { drools_symbol3=str; return drools_symbol3;}

    public String[] getDrools_symbol() {
        return drools_symbol;
    }
    public String[] setDrools_symbol(String[] arr) { drools_symbol=arr; return drools_symbol;}

    public String getDrools_operation1() {
        return drools_operation1;
    }
    public String setDrools_operation1(String str) { drools_operation1=str; return drools_operation1;}
    public String getDrools_scenario1() {
        return drools_scenario1;
    }
    public String setDrools_scenario1(String str) { drools_scenario1=str; return drools_scenario1;}

    int terminal_value_temp=TerminalDataController.value_temp;
    int terminal_value_wet=TerminalDataController.value_wet;
    String terminal_name=TerminalDataController.name;

    public int getFlag() {
        return flag;
    }
    public int setFlag(int num) { flag=num; return flag;}
}