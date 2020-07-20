package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/20 19:48
 * @Copyright: © 找家纺版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String version() {
        return "第一次自己写 springcloud ";
    }
}
