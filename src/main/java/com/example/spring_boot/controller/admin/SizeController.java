package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.payload.request.SizeRequest;
import com.example.spring_boot.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/size-manager")
public class SizeController {
    @Autowired
    SizeService sizeService;
    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getSizeList(
            @RequestBody SizeRequest sizeRequest) {
        return ResponseEntity.ok(sizeService.findAllSize(sizeRequest));
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> createSize(@RequestBody SizeRequest sizeRequest) {
        return ResponseEntity.ok(sizeService.create(sizeRequest));
    }
    @PostMapping ("/delete")
    public ResponseEntity<?> deteleSize(@RequestBody SizeRequest sizeRequest) {
        return ResponseEntity.ok(sizeService.detele(sizeRequest));
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateEvent(@RequestBody SizeRequest sizeRequest) {
        return ResponseEntity.ok(sizeService.update(sizeRequest));
    }
}
