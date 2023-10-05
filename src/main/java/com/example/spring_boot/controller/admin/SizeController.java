package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Property;
import com.example.spring_boot.entity.Size;
import com.example.spring_boot.security.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("SizeManager")
public class SizeController {

    @Autowired
    SizeService sizeService;
    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getSizeList() {
        return new  ResponseEntity(sizeService.findAllByIsDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "Size/{id}")
    public ResponseEntity<?> getSizeById(@PathVariable("id") long id) {

        return new  ResponseEntity(sizeService.findByID(id), HttpStatus.OK);
    }
    @GetMapping(value = "SizeDelete/{id}")
    public ResponseEntity<?> DeleteSize(@PathVariable("id") long id) {
        sizeService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }

    @PostMapping(value = "SizeUpdate")
    public ResponseEntity<?> UpdateSize(@RequestBody Size size) {
        return new  ResponseEntity(sizeService.save(size), HttpStatus.OK);
    }

}
