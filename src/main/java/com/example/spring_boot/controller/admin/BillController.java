package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.PageableRequest;
import com.example.spring_boot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/bill-manager")
public class BillController {
    @Autowired
    BillService billService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getBillList(
            @RequestBody BillRequest billRequest) {
        return ResponseEntity.ok(billService.findAllBill(billRequest));
    }




}
