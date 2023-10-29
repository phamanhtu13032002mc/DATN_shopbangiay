package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;
import com.example.spring_boot.service.OderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/oder-detail-manager")
public class OderDetailController {
    @Autowired
    OderDetailService oderDetailService;
    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getOderDetailList(OderDetailRequest oderDetailRequest) {
        return new ResponseEntity(oderDetailService.findAll(oderDetailRequest), HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        Optional<OrderDetailEntity> oderDetailRequest = oderDetailService.findByID(id);

        if (oderDetailRequest.isPresent()) {
            return new ResponseEntity(oderDetailRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
