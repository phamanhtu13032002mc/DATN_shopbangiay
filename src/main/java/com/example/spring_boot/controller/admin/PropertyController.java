package com.example.spring_boot.controller.admin;


import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Property;
import com.example.spring_boot.security.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("PropertyManager")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getPropertyList() {
        return new  ResponseEntity(propertyService.findAllByIsDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "Property/{id}")
    public ResponseEntity<?> getPropertyId(@PathVariable("id") long id) {

        return new  ResponseEntity(propertyService.findByID(id), HttpStatus.OK);
    }
    @GetMapping(value = "PropertyDelete/{id}")
    public ResponseEntity<?> DeleteProperty(@PathVariable("id") long id) {
        propertyService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }

    @PostMapping(value = "PropertyUpdate")
    public ResponseEntity<?> UpdateProperty(@RequestBody Property property) {
        return new  ResponseEntity(propertyService.save(property), HttpStatus.OK);
    }


}
