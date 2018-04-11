package com.example.webdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Ralf Chen on 2018/4/11 0011.
 */
@Controller
@Slf4j
public class ThymeleafController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "陈全");
        return "hello";
    }
}
