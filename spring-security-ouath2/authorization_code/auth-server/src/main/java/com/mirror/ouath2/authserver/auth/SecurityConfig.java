package com.mirror.ouath2.authserver.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: spring security 配置类
 * @create: 2020-05-02 20:25
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 这段配置的目的，实际上就是配置用户。
         * 例如你想用微信登录第三方网站，在这个过程中，
         * 你得先登录微信，登录微信就要你的用户名/密码信息，
         * 那么我们在这里配置的，其实就是用户的用户名/密码/角色信息
         */
        auth.inMemoryAuthentication()
                .withUser("huang")
                .password(passwordEncoder().encode("123"))
                .roles("user")
                .and()
                .withUser("mirror")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin();
    }
}
