package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/20 19:48
 */
@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String version() {
        return "第一次自己写 springcloud ";
    }
}
