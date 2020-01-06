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

    private int drools_threshold=WebDataController.threshold[0];
    private String drools_parameterName=WebDataController.parameterName[0];
    private String drools_symbol=WebDataController.symbol[0];
    private String drools_operation=WebDataController.operation[0];

    private int drools_threshold2=WebDataController.threshold[1];
    private String drools_parameterName2=WebDataController.parameterName[1];
    private String drools_symbol2=WebDataController.symbol[1];
    private String drools_operation2=WebDataController.operation[1];

    private int drools_threshold3=WebDataController.threshold[2];
    private String drools_parameterName3=WebDataController.parameterName[2];
    private String drools_symbol3=WebDataController.symbol[2];
    private String drools_operation3=WebDataController.operation[2];

    private int drools_threshold4=WebDataController.threshold[3];
    private String drools_parameterName4=WebDataController.parameterName[3];
    private String drools_symbol4=WebDataController.symbol[3];
    private String drools_operation4=WebDataController.operation[3];

    private int drools_threshold5=WebDataController.threshold[4];
    private String drools_parameterName5=WebDataController.parameterName[4];
    private String drools_symbol5=WebDataController.symbol[4];
    private String drools_operation5=WebDataController.operation[4];

    private int drools_threshold6=WebDataController.threshold[5];
    private String drools_parameterName6=WebDataController.parameterName[5];
    private String drools_symbol6=WebDataController.symbol[5];
    private String drools_operation6=WebDataController.operation[5];

    private int drools_threshold7=WebDataController.threshold[6];
    private String drools_parameterName7=WebDataController.parameterName[6];
    private String drools_symbol7=WebDataController.symbol[6];
    private String drools_operation7=WebDataController.operation[6];

    private int drools_threshold8=WebDataController.threshold[7];
    private String drools_parameterName8=WebDataController.parameterName[7];
    private String drools_symbol8=WebDataController.symbol[7];
    private String drools_operation8=WebDataController.operation[7];

    private int drools_threshold9=WebDataController.threshold[8];
    private String drools_parameterName9=WebDataController.parameterName[8];
    private String drools_symbol9=WebDataController.symbol[8];
    private String drools_operation9=WebDataController.operation[8];

    private int drools_threshold10=WebDataController.threshold[9];
    private String drools_parameterName10=WebDataController.parameterName[9];
    private String drools_symbol10=WebDataController.symbol[9];
    private String drools_operation10=WebDataController.operation[9];

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