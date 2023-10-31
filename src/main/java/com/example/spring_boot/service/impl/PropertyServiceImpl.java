package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.repository.PropertyRepository;
import com.example.spring_boot.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public PropertyEntity save(PropertyEntity propertyEntity) {
        return propertyRepository.save(propertyEntity);
    }

    @Override
    public void delete(Long id) {
        PropertyEntity propertyEntity = propertyRepository.findById(id).get();
        propertyEntity.setIsDelete(true);
        propertyRepository.save(propertyEntity);


    }

    @Override
    public Optional<PropertyEntity> findByID(Long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public Page<PropertyEntity> findAllProperties(PropertiesRequest propertiesRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(propertiesRequest.getPage()), Math.toIntExact(propertiesRequest.getSize()));
        return propertyRepository.findAllProperties(propertiesRequest, pageable);
    }
}
