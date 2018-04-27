package com.zjc.learn.userserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * Spring-Cloud
 *
 * @author Sandu
 * @datetime 2018/4/25 15:30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${learn.test}")
    private String learnTest;
    @GetMapping("/test")
    public Object test(String name) {
        return  learnTest;
    }
}
