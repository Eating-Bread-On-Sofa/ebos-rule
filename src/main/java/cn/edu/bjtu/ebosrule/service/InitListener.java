package cn.edu.bjtu.ebosrule.service;

import cn.edu.bjtu.ebosrule.controller.TerminalDataController;
import cn.edu.bjtu.ebosrule.controller.WebDataController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sound.midi.Track;


@Component
@Order(1)
public class InitListener implements ApplicationRunner {
    @Autowired
    MqFactory mqFactory;
    @Autowired
    TerminalDataController terminalDataController;
    @Value("${mq}")
    private String name;



    @Override
    public void run(ApplicationArguments arguments) {
        new Thread(() -> {
            MqConsumer mqConsumer = mqFactory.createConsumer("rules_terminal");
            while (true) {
                String msg = mqConsumer.subscribe();
                JSONObject info = JSON.parseObject(msg);
                System.out.println("规则引擎收到消息" + info);
                JSONArray jsonarray = info.getJSONArray("readings");
                JSONObject jsonpacket = jsonarray.getJSONObject(0);
                int value = jsonpacket.getIntValue("value");
                String name = jsonpacket.getString("name");
                String device = jsonpacket.getString("device");

                TerminalDataController.value=value;
                TerminalDataController.device = device;

                if (name.equals("TemperatureDeg"))
                    TerminalDataController.value_temp = value;
                else if (name.equals("Humidity"))
                    TerminalDataController.value_wet = value;

                TerminalDataController.name = name;
                try {
                    terminalDataController.Test();
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
