package com.example.spring_boot.controller.admin;


import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/property-manager")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getEventList(PropertiesRequest propertiesRequest) {
        return new ResponseEntity(propertyService.findAll(propertiesRequest), HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        Optional<PropertyEntity> propertyRequest = propertyService.findByID(id);

        if (propertyRequest.isPresent()) {
            return new ResponseEntity(propertyRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }



}
