package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Property;
import com.example.spring_boot.repository.propertyRepository;
import com.example.spring_boot.security.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    propertyRepository propertyRepository;
    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> findAllByIsDeleteFalse() {
        return propertyRepository.findAllByIsDeleteFase();
    }

    @Override
    public void delete(Long id) {
        Property property = propertyRepository.findById(id).get();
        property.setIsDelete(true);
        propertyRepository.save(property);


    }

    @Override
    public Optional<Property> findByID(Long id) {
        return propertyRepository.findById(id);
    }
}
