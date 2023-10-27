package com.example.spring_boot.service;

import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<PropertyEntity> findAll(PropertiesRequest propertiesRequest);

    PropertyEntity save(PropertyEntity propertyEntity);

    List<PropertyEntity> findAllByIsDeleteFalse();

    void delete(Long id);

    Optional<PropertyEntity> findByID(Long id);

}
