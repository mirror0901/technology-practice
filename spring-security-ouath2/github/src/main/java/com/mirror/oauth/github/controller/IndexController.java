package com.mirror.oauth.github.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-05-05 00:49
 **/
@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("authorization_code")
    public String authorization_code(String code) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", "***");
        map.put("client_secret", "***");
        map.put("state", "mirror");
        map.put("code", code);
        map.put("redirect_uri", "http://localhost:8080/authorization_code");
        Map<String,String> resp = restTemplate.postForObject("https://github.com/login/oauth/access_token", map, Map.class);
        System.out.println(resp);
        HttpHeaders httpheaders = new HttpHeaders();
        httpheaders.add("Authorization", "token " + resp.get("access_token"));
        HttpEntity<?> httpEntity = new HttpEntity<>(httpheaders);
        ResponseEntity<Map> exchange = restTemplate.exchange("https://api.github.com/user", HttpMethod.GET, httpEntity, Map.class);
        System.out.println("exchange.getBody() = " + new ObjectMapper().writeValueAsString(exchange.getBody()));
        return "forward:/index.html";
    }

}
