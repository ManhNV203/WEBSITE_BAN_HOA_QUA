package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {
    @RequestMapping("say-hello")
    public String sayHello(Model model){
        String ten = "xin chao spring";
        model.addAttribute("name",ten);
        return "hello";

    }

}
