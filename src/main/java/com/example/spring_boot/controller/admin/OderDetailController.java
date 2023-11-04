package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
import com.example.spring_boot.service.OrderDetailService;
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
    OrderDetailService oderDetailService;
    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getOderDetailList(
            @RequestBody OrderDetailRequest oderDetailRequest) {
        return ResponseEntity.ok(oderDetailService.findAllOderDetail(oderDetailRequest));
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
    @PostMapping(value = "/create")
    public ResponseEntity<?> createCategory(@RequestBody OrderDetailRequest oderDetailRequest) {
        return ResponseEntity.ok(oderDetailService.create(oderDetailRequest));
    }
    @PostMapping ("/delete")
    public ResponseEntity<?> deleteCategory(@RequestBody OrderDetailRequest orderDetailRequest) {
        return ResponseEntity.ok(oderDetailService.detele(orderDetailRequest));
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateCategory(@RequestBody OrderDetailRequest orderDetailRequest) {
        return ResponseEntity.ok(oderDetailService.update(orderDetailRequest));
    }
}
