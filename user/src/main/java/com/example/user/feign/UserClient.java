package com.example.user.feign;

import com.example.user.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.xl.user.feign.IUserClient;

/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/21 15:47
 * @Copyright: © 找家纺版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@RestController
public class UserClient implements IUserClient {
    @Autowired
    private TestService testService;

    @Override
    public String test() {
        return testService.test();
    }
}
