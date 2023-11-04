package com.example.spring_boot.service;

import com.example.spring_boot.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<UserEntity> findByisDeleteFalse();

    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findByID(Long id);

    List<UserEntity> findByNameLike(String name);

    UserEntity delete (Long id);

}
