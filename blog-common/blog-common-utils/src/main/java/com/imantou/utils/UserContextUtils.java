package com.gaobug.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户上下文工具类
 */
@Slf4j
public class UserContextUtils {

    public static String getAuthToken() {
        HttpServletRequest request = RequestUtils.getRequest();
        if (request != null) {
            return request.getHeader("auth-token");
        }
        return null;
    }
}
