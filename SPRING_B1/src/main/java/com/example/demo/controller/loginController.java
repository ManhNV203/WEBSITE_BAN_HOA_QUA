package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class loginController {
    @GetMapping("login")
    public String getLogin(){
        return "login";
    }
    @PostMapping("login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
//            @RequestParam(name = "remember", defaultValue = "false") boolean remember
            @RequestParam(name = "remember") Optional<Boolean> remember
            ){
        System.out.println(username);
        System.out.println(password);
        if (remember.isEmpty()){
            System.out.println("khoong nhow dang nhap");
        }else {
            System.out.println(remember.get());
        }
        return "login";
    }
}
