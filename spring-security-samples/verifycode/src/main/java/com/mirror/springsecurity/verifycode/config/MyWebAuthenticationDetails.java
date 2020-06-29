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
        String code = request.getParameter("code");
        String verify_code = (String) request.getSession().getAttribute("verify_code");
        if (code != null && verify_code != null && code.equals(verify_code)) {
            isPassed = true;
        }
    }

    public boolean isPassed() {
        return isPassed;
    }

}
