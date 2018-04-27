package com.zjc.learn.loginserver.client;

import org.springframework.stereotype.Component;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * Spring-Cloud
 *
 * @author Sandu
 * @datetime 2018/4/27 10:15
 */
@Component
public class UserClientHystrix implements UserClient {
    @Override
    public Object test(String name) {
        return "调用失败,服务异常...";
    }
}
