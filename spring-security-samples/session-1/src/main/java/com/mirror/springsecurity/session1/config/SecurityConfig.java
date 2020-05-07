package com.mirror.springsecurity.session1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * @author: mirror
 * @date: 2020/5/7 16:26
 * @description:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("mirror")
                .password("123")
                .roles("admin");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .permitAll()
                .and()
                .csrf().disable()
                .sessionManagement()
                //最大在线人数 可以踢掉之前登陆的人员或者登陆之后不允许其他人员登录
                .maximumSessions(1)
                //设置这个之后,则登录之后不允许其他人员登录
                .maxSessionsPreventsLogin(true);
    }

    /**
     * 为什么要加这个 Bean 呢？
     * 因为在 Spring Security 中，它是通过监听 session 的销毁事件，来及时的清理 session 的记录。
     * 用户从不同的浏览器登录后，都会有对应的 session，当用户注销登录之后，session 就会失效，
     * 但是默认的失效是通过调用 StandardSession#invalidate 方法来实现的，
     * 这一个失效事件无法被 Spring 容器感知到，进而导致当用户注销登录之后，
     * Spring Security 没有及时清理会话信息表，以为用户还在线，
     * 进而导致用户无法重新登录进来.
     * 为了解决这一问题，我们提供一个 HttpSessionEventPublisher ，
     * 这个类实现了 HttpSessionListener 接口，在该 Bean 中，
     * 可以将 session 创建以及销毁的事件及时感知到，
     * 并且调用 Spring 中的事件机制将相关的创建和销毁事件发布出去，
     * 进而被 Spring Security 感知到
     *
     *
     * @return
     */
    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }


}
