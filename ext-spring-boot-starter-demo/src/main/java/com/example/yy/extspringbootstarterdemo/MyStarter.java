package com.example.yy.extspringbootstarterdemo;

/**
 * Created by Ralf Chen on 2018/4/13 0013.
 */
public class MyStarter {
    private String name = "test";

    public MyStarter(String name) {
        this.name = name;
    }
    public MyStarter(){

    }

    @Override
    public String toString() {
        return "MyStarter{" +
                "name='" + name + '\'' +
                '}';
    }
}
