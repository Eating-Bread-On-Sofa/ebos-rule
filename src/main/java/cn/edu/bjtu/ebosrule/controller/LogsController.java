package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.service.LogService;
import cn.edu.bjtu.ebosrule.service.LoggerService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/api")
@RestController
public class LogsController {
    @Autowired
    LogService logService;
    @Autowired
    LoggerService loggerService;

    @CrossOrigin
    @RequestMapping ("/logtest")
    public String logTest1(){
        logService.debug("rule1");
        logService.info("rule2");
        logService.warn("rule3");
        logService.error("rule4");
        return "成功";
    }
    @CrossOrigin
    @GetMapping("/logtest")
    public JSONArray logTest2(){
        return logService.findAll();
    }

    @CrossOrigin
    @RequestMapping ("/loggertest")
    public String loggerTest1(){
        loggerService.function1("rule1");
        loggerService.function2("rule2");
        loggerService.function3("rule3");
        loggerService.function4("rule4");
        return "成功";
    }
    @CrossOrigin
    @GetMapping("/loggertest")
    public JSONArray loggerTest2(){
        return loggerService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/log",method = RequestMethod.GET)
    public JSONArray logTest( Date date1, Date date2, String source, String category) throws ParseException {
        SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat ds =  new SimpleDateFormat("yyyy-MM-dd ");
        Date startDate = df.parse(ds.format(date1)+"00:00:00");
        Date endDate = df.parse(ds.format(date2)+"23:59:59");
        return logService.find(startDate, endDate, source, category);
    }

    @CrossOrigin
    @RequestMapping(value = "/logger",method = RequestMethod.GET)
    public JSONArray loggerTest( Date date1, Date date2, String source, String function) throws ParseException {
        SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat ds =  new SimpleDateFormat("yyyy-MM-dd ");
        Date startDate = df.parse(ds.format(date1)+"00:00:00");
        Date endDate = df.parse(ds.format(date2)+"23:59:59");
        return loggerService.find(startDate,endDate,source,function);
    }
}
