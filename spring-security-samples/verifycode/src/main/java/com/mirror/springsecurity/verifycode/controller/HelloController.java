package com.mirror.springsecurity.verifycode.controller;

import com.mirror.springsecurity.verifycode.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-05-05 13:36
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("hello")
    public String hello() {
        helloService.hello();
        return "hello";
    }

}
