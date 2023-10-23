package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.PropertyEntity;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<PropertyEntity> findAll();

    PropertyEntity save(PropertyEntity propertyEntity);

    List<PropertyEntity> findAllByIsDeleteFalse();

    void delete(Long id);

    Optional<PropertyEntity> findByID(Long id);

}
