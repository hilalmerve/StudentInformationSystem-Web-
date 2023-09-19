package com.example.demo.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.entity.Person;


public class UserInfoUserDetails implements UserDetails{
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(Person personInfo) {
        id = personInfo.getId();
        name = personInfo.getName();
        surname = personInfo.getSurname();
        email = personInfo.getEmail();
        password = personInfo.getPassword();
        authorities = Arrays.stream(personInfo.getRoles().name().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return surname;
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
