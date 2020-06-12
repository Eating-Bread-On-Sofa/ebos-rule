package cn.edu.bjtu.ebosrule.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface LogService {
    void debug(String message);

    void info(String message);

    void warn(String message);

    void error(String message);

    String getTop();

    JSONArray findAll();

    JSONArray find(Date date1,Date date2,String source,String category);

    JSONArray findLogByCategory(String category);

    JSONArray findLogBySource(String source);

    JSONArray findLogBySourceAndCategory(String source, String category);

}
