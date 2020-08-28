package cn.edu.bjtu.ebosrule.service;

import cn.edu.bjtu.ebosrule.entity.Subscribe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscribeService {
    void save( String subTopic);
    void delete(String subTopic);
    List<Subscribe> findAll();
    List<Subscribe> findByServiceName();
}
