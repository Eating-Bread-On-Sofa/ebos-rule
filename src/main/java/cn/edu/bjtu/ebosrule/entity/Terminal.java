package cn.edu.bjtu.ebosrule.entity;

import cn.edu.bjtu.ebosrule.controller.TerminalDataController;
import cn.edu.bjtu.ebosrule.controller.WebDataController;
import lombok.Data;

@Data

public class Terminal {

    private int flag1 = 0;
    private int flag2 = 0;
    private int flag3 = 0;
    private int flag4 = 0;
    private int flag5 = 0;
    private int flag6 = 0;
    private int flag7 = 0;
    private int flag8 = 0;
    private int flag9 = 0;
    private int flag10 = 0;
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

    public int getFlag1() {
        return flag1;
    }
    public int setFlag1(int num) { flag1=num; return flag1;}

    public int getFlag2() {
        return flag2;
    }
    public int setFlag2(int num) { flag2=num; return flag2;}

    public int getFlag3() {
        return flag3;
    }
    public int setFlag3(int num) { flag3=num; return flag3;}

    public int getFlag4() {
        return flag4;
    }
    public int setFlag4(int num) { flag4=num; return flag4;}

    public int getFlag5() {
        return flag5;
    }
    public int setFlag5(int num) { flag5=num; return flag5;}

    public int getFlag6() {
        return flag6;
    }
    public int setFlag6(int num) { flag6=num; return flag6;}

    public int getFlag7() {
        return flag7;
    }
    public int setFlag7(int num) { flag7=num; return flag7;}

    public int getFlag8() {
        return flag8;
    }
    public int setFlag8(int num) { flag8=num; return flag8;}

    public int getFlag9() {
        return flag9;
    }
    public int setFlag9(int num) { flag9=num; return flag9;}

    public int getFlag10() {
        return flag10;
    }
    public int setFlag10(int num) { flag10=num; return flag10;}
}