package com.example.spring_boot.service;

import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    PropertyEntity save(PropertyEntity propertyEntity);

    void delete(Long id);

    Optional<PropertyEntity> findByID(Long id);

    Page<PropertyEntity> findAllProperties(PropertiesRequest propertiesRequest);

    Object create(PropertiesRequest propertiesRequest);

    Object detele(PropertiesRequest propertiesRequest);

    Object update(PropertiesRequest propertiesRequest);

    Object findByNameLike(PropertiesRequest propertiesRequest);
}
