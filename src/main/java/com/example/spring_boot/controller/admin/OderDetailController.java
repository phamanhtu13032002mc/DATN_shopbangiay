package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.entity.OderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;
import com.example.spring_boot.service.OderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @PostMapping(value = "/find-all")
    public ResponseEntity<Page<OderDetailEntity>> getOderDetailList(@RequestBody OderDetailRequest pageableOderDetailRequest) {
        PageRequest pageRequest = PageRequest.of(pageableOderDetailRequest.getPage(), pageableOderDetailRequest.getSize());
        Page<OderDetailEntity> oderDetailList = oderDetailService.findAll(pageableOderDetailRequest.getOderDetailRequest(), pageRequest);
        return new ResponseEntity<>(oderDetailList, HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        Optional<OderDetailEntity> oderDetailRequest = oderDetailService.findByID(id);

        if (oderDetailRequest.isPresent()) {
            return new ResponseEntity(oderDetailRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
