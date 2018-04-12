package com.example.yy.springbootclientdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ralf Chen on 2018/4/12 0012.
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-provider/hello", String.class);
        return responseEntity.getBody();
    }
}
