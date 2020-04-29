package com.mirror95.springsecurity.entity;

import javax.persistence.*;

/**
 * @author: mirror
 * @date: 2020/4/29 19:44
 * @description:https://www.cnblogs.com/ealenxie/p/9293768.html
 */
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userUuid;   //用户UUID
    private String username;    //用户名
    private String password;    //用户密码
    private String email;       //用户邮箱
    private String telephone;   //电话号码
    private String role;        //用户角色
    private String image;       //用户头像
    private String lastIp;     //上次登录IP
    private String lastTime;   //上次登录时间

}
