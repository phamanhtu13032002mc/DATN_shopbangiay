package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<Property> findAll();

    Property save(Property property);

    List<Property> findAllByIsDeleteFalse();

    void delete(Long id);

    Optional<Property> findByID(Long id);

}
