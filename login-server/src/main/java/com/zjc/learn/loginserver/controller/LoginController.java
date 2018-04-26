package com.zjc.learn.loginserver.controller;

import com.zjc.learn.loginserver.client.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * Spring-Cloud
 *
 * @author Sandu
 * @datetime 2018/4/26 9:57
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private UserClient userClient;
    @GetMapping()
    public String checkLogin(String name) {
        Object test = userClient.test(name);
        return test.equals(test) ? ":success" : "failed";
    }
}
