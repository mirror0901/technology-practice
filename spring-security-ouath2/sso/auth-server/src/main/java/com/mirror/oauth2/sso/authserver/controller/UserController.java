package com.mirror.oauth2.sso.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-05-04 23:05
 **/
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal getCurrentUser(Principal principal) {
        System.out.println(principal);
        return principal;
    }

}
