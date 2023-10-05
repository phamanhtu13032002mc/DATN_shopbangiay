package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<User> findByisDeleteFalse();

    User save(User user);

    Optional<User> findByID(Long id);

    List<User> findByNameLike(String name);

    User delete (Long id);

}
