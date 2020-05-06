package com.mirror.springsecurity.verifycode.service;

import com.mirror.springsecurity.verifycode.config.MyWebAuthenticationDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author: mirror
 * @date: 2020/5/6 11:28
 * @description:
 */
@Service
public class HelloService {

    public void hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails();
        System.out.println(details);
    }

}
