package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.UserEntity;
import com.example.spring_boot.repository.UserRepository;
import com.example.spring_boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public List<UserEntity> findByisDeleteFalse() {
        return userRepository.findAllByDeleteFalse();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findByID(Long id) {
        return userRepository.findById(id) ;
    }

    @Override
    public List<UserEntity> findByNameLike(String name) {
        return userRepository.findUserByLike(name);
    }

    @Override
    public UserEntity delete(Long id) {
         UserEntity userEntity = userRepository.findById(id).get();
         userEntity.setDelete(true);
         userRepository.save(userEntity);
        return userEntity;
    }
}
