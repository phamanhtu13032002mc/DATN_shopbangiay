package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.entity.ERole;
import com.example.spring_boot.entity.RoleEntity;
import com.example.spring_boot.entity.UserEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.SaveUserRequest;
import com.example.spring_boot.repository.CustomerRepository;
import com.example.spring_boot.repository.RoleRepository;
import com.example.spring_boot.repository.UserRepository;
import com.example.spring_boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CustomerRepository customerRepository;

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

    @Override
    public DataObj SaveUser(SaveUserRequest saveUserRequest) {
        try {
            UserEntity user = new UserEntity();
            Set<RoleEntity> roleEntities = new HashSet<>();
            RoleEntity userRoleEntity = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roleEntities.add(userRoleEntity);
            user.setUsername(saveUserRequest.getUsername());
            user.setEmail(saveUserRequest.getEmail());
            user.setPhone(saveUserRequest.getPhone());
            user.setPassword (encoder.encode(saveUserRequest.getPassword()));
            user.setRoles(roleEntities);
            UserEntity userEntity =  userRepository.save(user);
            CustomerEntity customer = new CustomerEntity();
            customer.setAddress(saveUserRequest.getAddress());
            customer.setEmail(saveUserRequest.getEmail());
            customer.setPhone(saveUserRequest.getPhone());
            customer.setFullName(saveUserRequest.getFullName());
            customer.setUserEntity(userEntity);
            customerRepository.save(customer);
            return new DataObj().setEdesc("200").setEdesc("tạo tài khoản mới thành công");

        }catch (Exception e){
            return new DataObj().setEdesc("420").setEdesc("tạo tài khoản mới không thành công");

        }
    }
}
