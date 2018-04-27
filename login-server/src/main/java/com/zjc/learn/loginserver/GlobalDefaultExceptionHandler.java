package com.zjc.learn.loginserver;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * Spring-Cloud
 *
 * @author Sandu
 * @datetime 2018/4/27 10:20
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Object defaultException(HttpServletRequest req, Exception e) {
        Map<String, String> ret = new HashMap<>();
        ret.put("exception:", e.getMessage());
        ret.put("url:", req.getRequestURI());
        return ret;
    }
}
