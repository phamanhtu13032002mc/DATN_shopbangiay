package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.repository.PropertyRepository;
import com.example.spring_boot.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;
    @Override
    public List<PropertyEntity> findAll(PropertiesRequest propertiesRequest) {
        return propertyRepository.findAll();
    }

    @Override
    public PropertyEntity save(PropertyEntity propertyEntity) {
        return propertyRepository.save(propertyEntity);
    }

    @Override
    public List<PropertyEntity> findAllByIsDeleteFalse() {
        return propertyRepository.findAllByIsDeleteFase();
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
}
