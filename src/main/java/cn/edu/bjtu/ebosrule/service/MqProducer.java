package cn.edu.bjtu.ebosrule.service;

public interface MqProducer {
    void publish(String topic, String message);
}
