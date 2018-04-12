package com.example.yy.extspringbootstarterdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExtSpringBootStarterDemoApplication implements CommandLineRunner {
    @Autowired
    private MyStarter myStarter;

    public static void main(String[] args) {
        SpringApplication.run(ExtSpringBootStarterDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(myStarter);
    }
}
