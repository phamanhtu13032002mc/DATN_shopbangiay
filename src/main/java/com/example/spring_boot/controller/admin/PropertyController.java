package com.example.spring_boot.controller.admin;


import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.security.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/property-manager")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getPropertyList() {
        return new  ResponseEntity(propertyService.findAllByIsDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<?> getPropertyId(@PathVariable("id") long id) {

        return new  ResponseEntity(propertyService.findByID(id), HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable("id") long id) {
        propertyService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> updateProperty(@RequestBody PropertyEntity propertyEntity) {
        return new  ResponseEntity(propertyService.save(propertyEntity), HttpStatus.OK);
    }


}
