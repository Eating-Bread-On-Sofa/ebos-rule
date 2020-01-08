package cn.edu.bjtu.ebosrule.service;

public interface MqFactory {
    MqProducer createProducer();
    MqConsumer createConsumer(String topic);
}
