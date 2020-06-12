package cn.edu.bjtu.ebosrule.service.impl;

import cn.edu.bjtu.ebosrule.entity.Log;
import cn.edu.bjtu.ebosrule.entity.Logger;
import cn.edu.bjtu.ebosrule.service.LoggerService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService{

    private static String serviceName = "规则引擎";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void function1(String message){
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setFunction("功能1");
        logger.setMessage(message);
        logger.setSource(serviceName);
        mongoTemplate.save(logger);
    }
    @Override
    public void function2(String message){
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setFunction("功能2");
        logger.setMessage(message);
        logger.setSource(serviceName);
        mongoTemplate.save(logger);
    }
    @Override
    public void function3(String message){
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setFunction("功能3");
        logger.setMessage(message);
        logger.setSource(serviceName);
        mongoTemplate.save(logger);
    }
    @Override
    public void function4(String message){
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setFunction("功能4");
        logger.setMessage(message);
        logger.setSource(serviceName);
        mongoTemplate.save(logger);
    }

    @Override
    public JSONArray findAll(){
        List<Logger> list = mongoTemplate.findAll(Logger.class,"logger");
        return list2json(list);
    }

    @Override
    public JSONArray find(Date date1, Date date2, String source, String function){
        if (source.equals("全部")){
            if (function.equals("全部")){
                Query query = Query.query(Criteria.where("date").gte(date1).lte(date2));
                List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
                return list2json(list);
            }else{
                Query query = Query.query(Criteria.where("date").gte(date1).lte(date2).and("function").is(function));
                List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
                return list2json(list);
            }
        }else{
            if (function.equals("全部")){
                Query query = Query.query(Criteria.where("date").gte(date1).lte(date2).and("source").is(source));
                List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
                return list2json(list);
            }else{
                Query query = Query.query(Criteria.where("date").gte(date1).lte(date2).and("function").is(function).and("source").is(source));
                List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
                return list2json(list);
            }
        }
    }

    @Override
    public JSONArray findLogByFunction(String function){
        Query query = Query.query(Criteria.where("function").is(function));
        List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
        return list2json(list);
    }
    @Override
    public JSONArray findLogBySource(String source){
        Query query = Query.query(Criteria.where("source").is(source));
        List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
        return list2json(list);
    }
    @Override
    public JSONArray findLogBySourceAndFunction(String source, String function){
        Query query = Query.query(Criteria.where("source").is(source).and("function").is(function));
        List<Logger> list = mongoTemplate.find(query,Logger.class,"logger");
        return list2json(list);
    }

    @Override
    public String getTop() {
        // 获取堆栈信息
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        // 最原始被调用的堆栈信息
        StackTraceElement caller = null;
        // 日志类名称
        String logClassName = LogServiceImpl.class.getName();
        // 循环遍历到日志类标识
        boolean isEachLogClass = false;
        // 遍历堆栈信息，获取出最原始被调用的方法信息
        for (StackTraceElement s : callStack) {
            // 遍历到日志类
            if (logClassName.equals(s.getClassName())) {
                isEachLogClass = true;
            }
            // 下一个非日志类的堆栈，就是最原始被调用的方法
            if (isEachLogClass) {
                if(!logClassName.equals(s.getClassName())) {
                    caller = s;
                    break;
                }
            }
        }
        if(caller != null) {
            return caller.toString();
        }else{
            return  "";
        }
    }

    private JSONArray list2json(List<Logger> list){
        JSONArray jsonArray = new JSONArray();
        for(Logger logger:list){
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(logger);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
