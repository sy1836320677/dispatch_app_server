package com.example.dispatch_app_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class test {
    @RequestMapping("/{id}")
    public String hello(@PathVariable String id){
        return id;
    }

}
