package com.example.yy.springcloudeurekaserverdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerDemo2Application.class, args);
    }
}
