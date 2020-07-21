package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xl.user.feign.IUserClient;

/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/21 15:51
 * @Copyright: © 找家纺版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@RestController
public class TestController {
    @Autowired
    private IUserClient userClient;

    @GetMapping(value = "/test")
    public String version() {
        return "" + userClient.test();
    }
}
