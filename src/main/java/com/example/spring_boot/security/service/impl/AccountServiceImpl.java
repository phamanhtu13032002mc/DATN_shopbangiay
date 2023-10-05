package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.User;
import com.example.spring_boot.repository.UserRepository;
import com.example.spring_boot.security.service.AccountService;
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
    public List<User> findByisDeleteFalse() {
        return userRepository.findAllByDeleteFalse();
    }

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByID(Long id) {
        return userRepository.findById(id) ;
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepository.findUserByLike(name);
    }

    @Override
    public User delete(Long id) {
         User user = userRepository.findById(id).get();
         user.setDelete(true);
         userRepository.save(user);
        return user;
    }
}
