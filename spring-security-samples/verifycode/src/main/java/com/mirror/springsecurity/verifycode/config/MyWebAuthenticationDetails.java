package com.mirror.springsecurity.verifycode.config;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: mirror
 * @date: 2020/5/6 19:17
 * @description:
 */
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private boolean isPassed;

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);

    }
}
