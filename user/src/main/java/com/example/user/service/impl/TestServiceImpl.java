package com.example.user.service.impl;

import com.example.user.service.TestService;
import io.seata.tm.api.GlobalTransactionContext;
import org.springframework.stereotype.Service;

/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/21 15:42
 * @Copyright: © 找家纺版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "这是第一次feign 调用成功了";
    }
}
