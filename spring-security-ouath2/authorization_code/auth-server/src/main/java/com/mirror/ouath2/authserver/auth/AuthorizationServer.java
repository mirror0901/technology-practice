package com.mirror.ouath2.authserver.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 对授权服务器做进一步的详细配置
 * 加上 @EnableAuthorizationServer 注解，表示开启授权服务器的自动化配置。
 * @create: 2020-05-02 20:45
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    TokenStore tokenStore;
    @Autowired
    ClientDetailsService clientDetailsService;

    /**
     * 主要用来配置 Token 的一些基本信息，
     * 例如 Token 是否支持刷新、Token 的存储位置、Token 的有效期以及刷新 Token 的有效期等等
     *
     * @return
     */
    @Bean
    AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        services.setAccessTokenValiditySeconds(60 * 60 * 2);
        services.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);
        return services;
    }

    @Bean
    AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    /**
     * 用来配置令牌端点的安全约束，也就是这个端点谁能访问，谁不能访问。
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /**
         * checkTokenAccess 是指一个 Token 校验的端点，这个端点我们设置为可以直接访问
         * （在后面，当资源服务器收到 Token 之后，需要去校验 Token 的合法性，就会访问这个端点）。
         */
        security.checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 用来配置客户端的详细信息
     * 授权服务器要做两方面的检验，一方面是校验客户端，另一方面则是校验用户
     * 分别配置了客户端的 id，secret、资源 id、授权类型、授权范围以及重定向 uri
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("mirror")
                .secret(new BCryptPasswordEncoder().encode("123"))
                .resourceIds("res1")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("all")
                .redirectUris("http://localhost:8082/index.html");
    }

    /**
     * 这里用来配置令牌的访问端点和令牌服务
     * authorizationCodeServices用来配置授权码的存储，
     * 这里我们是存在在内存中，tokenServices 用来配置令牌的存储，
     * 即 access_token 的存储位置，这里我们也先存储在内存中
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authorizationCodeServices(authorizationCodeServices())
                .tokenServices(tokenServices());
    }


}
