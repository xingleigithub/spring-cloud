package org.xl.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Desc:
 * @author: xing-lei
 * @Time: 2020/7/21 15:44
 * @Copyright: © 找家纺版权所有
 * @Warning: 本内容仅限于公司内部传阅, 禁止外泄或用于其它商业目的
 */
@FeignClient("user")
public interface IUserClient {
    String API_PREFIX = "/client";
    String TEST=API_PREFIX+"/test";

    @GetMapping(TEST)
    String test();
}
