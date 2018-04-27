package com.zjc.learn.loginserver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * Spring-Cloud
 *
 * @author Sandu
 * @datetime 2018/4/26 9:59
 */
@FeignClient(name = "user-service",fallback = UserClientHystrix.class)
public interface UserClient {
    @GetMapping("/user/test")
    Object test(@RequestParam("name") String name);
}
