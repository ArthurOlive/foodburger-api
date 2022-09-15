package com.api.foodburg.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.foodburg.models.UserSystem;


public class UserCustomDetails implements UserDetails {

    private UserSystem user;
    private String username;
    private String password;
    private String role;

    public String getRole() {
        return this.role;
    }

    public UserCustomDetails(UserSystem user) {

        this.user = user;
        this.username = user.getAuth().getUsername();
        this.password = user.getAuth().getPassword();
        //this.role = user.getRole().getName();

    }

    public UserSystem getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.role == null)
            return null;

        Collection<GrantedAuthority> auths = new ArrayList<>();

        auths.add(new SimpleGrantedAuthority("ROLE_" + role));

        return auths;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
