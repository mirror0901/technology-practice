package com.mirror.springsecurity.pojo;

import com.mirror.springsecurity.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-29 23:15
 **/
public class SecurityUserDTO extends UserEntity implements UserDetails {

    public static final long serialVersionUID = 1L;

    public SecurityUserDTO(UserEntity userEntity) {
        if (userEntity != null) {
            this.setUserUuid(userEntity.getUserUuid());
            this.setUsername(userEntity.getUsername());
            this.setPassword(userEntity.getPassword());
            this.setEmail(userEntity.getEmail());
            this.setTelephone(userEntity.getTelephone());
            this.setRole(userEntity.getRole());
            this.setImage(userEntity.getImage());
            this.setLastIp(userEntity.getLastIp());
            this.setLastTime(userEntity.getLastTime());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String username = this.getUsername();
        if (username != null) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);
            authorities.add(authority);
        }
        return authorities;
    }

    /**
     * 账户是否未过期,过期无法验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据（密码）,过期的凭据防止认证
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用，禁用的用户不能身份验证
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
