package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.repository.PropertyRepository;
import com.example.spring_boot.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public Object create(PropertiesRequest propertiesRequest) {
        try {
            if (propertiesRequest.getName() == null) {
                return new DataObj().setEdesc("Name event not null !!!");
            }

            // Kiểm tra xem tên đã tồn tại hay chưa
            boolean isNameExists = propertyRepository.existsByName(propertiesRequest.getName());

            if (isNameExists) {
                return new DataObj().setEdesc("Tên đã tồn tại trong cơ sở dữ liệu");
            } else {
                PropertyEntity property = new PropertyEntity();
                property.setName(propertiesRequest.getName());

                return new DataObj()
                        .setEcode("200")
                        .setEdesc("Create Complete")
                        .setData(propertyRepository.save(property));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating", e);
        }
    }

    @Override
    public Object detele(PropertiesRequest propertiesRequest) {
        try {
            Optional<PropertyEntity> propertyOptional = propertyRepository.findById(propertiesRequest.getIdProperty());
            if (propertyOptional.isEmpty()) {
                return new DataObj().setEcode("400").setEdesc("ID does not exit !");
            } else {
                PropertyEntity property = propertyOptional.get();
                property.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(propertyRepository.save(property));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error delete property !!");
        }
    }

    @Override
    public Object update(PropertiesRequest propertiesRequest) {
        try {
            PropertyEntity property = propertyRepository.findById(propertiesRequest.getIdProperty()).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id does not exist !!");
            });
            property.setName(propertiesRequest.getName());
            return new DataObj().setEcode("200").setEdesc("update complete").setData(propertyRepository.save(property));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error updating properties");
        }
    }

    @Override
    public Object findByNameLike(PropertiesRequest propertiesRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(propertiesRequest.getPage()), Math.toIntExact(propertiesRequest.getSize()));
        Page<PropertyEntity> propertyEntities = propertyRepository.findByNameLike(propertiesRequest.getName(), pageable);

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData(propertyEntities.getContent());

        return dataObj;
    }
}
