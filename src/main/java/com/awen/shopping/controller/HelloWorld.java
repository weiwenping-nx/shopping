package com.awen.shopping.controller;

import com.awen.shopping.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awen")
public class HelloWorld {
    @Autowired
    private Iservice service;
    @GetMapping("/say")
    public String say(){
        String name = service.getIdName();
        return "i love " + name;
    }
}
