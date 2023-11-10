package com.example.spring_boot.controller;

import com.example.spring_boot.service.UserDetailImpl;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class BaseController {
    public Optional<UserDetailImpl> getAuthCredentials(){
        return Optional.ofNullable((UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
    public Long getAuthUID() {
        return getAuthCredentials().map(UserDetailImpl::getId).orElse(null);
    }
}
