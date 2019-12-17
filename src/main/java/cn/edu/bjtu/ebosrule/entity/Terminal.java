package cn.edu.bjtu.ebosrule.entity;

import cn.edu.bjtu.ebosrule.controller.TerminalDataController;
import cn.edu.bjtu.ebosrule.controller.WebDataController;
import lombok.Data;

@Data

public class Terminal {

    private int flag1 = 0;
    private int flag2 = 0;

    private int threshold=WebDataController.threshold;
    private String parameterName=WebDataController.parameterName;
    private String symbol=WebDataController.symbol;
    private String operation=WebDataController.operation;

    int terminal_value=TerminalDataController.value;
    String terminal_name=TerminalDataController.name;

    public int getFlag1() {
        return flag1;
    }
    public int getFlag2() {
        return flag2;
    }
    public int setFlag1(int num) { flag1=num; return flag1;}
    public int setFlag2(int num) { flag2=num; return flag2;}
}