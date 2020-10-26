package cn.edu.bjtu.ebosrule.controller;

import cn.edu.bjtu.ebosrule.entity.RestTemplateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequestMapping("/api")
@RestController
public class postController {
    public static void sendPostRequest(String url, Map<String, Object> params){
        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
        String result = restTemplate.postForObject(url, params, String.class);
        System.out.println(result);
    }

}
