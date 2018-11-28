package com.auth.sp.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sys/redis")
public class RedisController {

    @RequestMapping("/list")
    public String RedisList(){
        String name = "1111111";
        return name;
    }

}
