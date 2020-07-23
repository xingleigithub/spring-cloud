package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/13 10:40
 */

@RefreshScope
@RestController
public class NacosConfigApi {
    @Value("${version}")
    private String version;


    @GetMapping(value = "/config/version")
    public String version() {
        return "Hello Nacos Config " + version;
    }
}

