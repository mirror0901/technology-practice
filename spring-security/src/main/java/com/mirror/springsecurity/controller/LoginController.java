package com.mirror.springsecurity.controller;

import com.mirror.springsecurity.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-30 00:22
 **/
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    /**
     * 为了从session获取用户信息,可以配置如下
     *
     * @return
     */
    public UserEntity getUserEntity() {
        UserEntity userEntity = new UserEntity();
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication authentication = ctx.getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            userEntity = (UserEntity) authentication.getPrincipal();
        }
        return userEntity;
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
