package cn.edu.bjtu.ebosrule.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface LoggerService {

    void function1(String message);

    void function2(String message);

    void function3(String message);

    void function4(String message);

    String getTop();

    JSONArray findAll();

    JSONArray find(Date date1, Date date2, String source, String function);

    JSONArray findLogByFunction(String function);

    JSONArray findLogBySource(String source);

    JSONArray findLogBySourceAndFunction(String source, String function);
}
