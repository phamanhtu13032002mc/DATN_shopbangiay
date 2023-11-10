package com.example.spring_boot.controller.admin;


import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
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

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getPropertyList(
            @RequestBody PropertiesRequest propertiesRequest) {
        return ResponseEntity.ok(propertyService.findAllProperties(propertiesRequest));
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
    @PostMapping(value = "/create")
    public ResponseEntity<?> createProperty(@RequestBody PropertiesRequest propertiesRequest) {
        return ResponseEntity.ok(propertyService.create(propertiesRequest));
    }
    @PostMapping ("/delete")
    public ResponseEntity<?> deteleProperty(@RequestBody PropertiesRequest propertiesRequest) {
        return ResponseEntity.ok(propertyService.detele(propertiesRequest));
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateProperty(@RequestBody PropertiesRequest propertiesRequest) {
        return ResponseEntity.ok(propertyService.update(propertiesRequest));
    }
    @PostMapping(value = "/find-by-name-like")
    public ResponseEntity<?> findByNameLike(@RequestBody PropertiesRequest propertiesRequest) {
        return ResponseEntity.ok(propertyService.findByNameLike(propertiesRequest));
    }



}
