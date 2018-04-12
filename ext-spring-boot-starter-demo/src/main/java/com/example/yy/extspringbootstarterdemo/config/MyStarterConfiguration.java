package com.example.yy.extspringbootstarterdemo.config;

import com.example.yy.extspringbootstarterdemo.MyStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ralf Chen on 2018/4/13 0013.
 */
@Configuration
@EnableConfigurationProperties(MyStaterProperties.class)
@ConditionalOnClass(MyStarter.class)
public class MyStarterConfiguration {

    @Autowired
    private MyStaterProperties myStaterProperties;

    private String name;

    @Bean
    public MyStarter myStarter() {
        return new MyStarter(myStaterProperties.getName());
    }


}
@ConfigurationProperties(prefix = "my-starter")

class MyStaterProperties{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
