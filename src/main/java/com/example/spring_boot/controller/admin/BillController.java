package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.service.BillService;
import com.example.spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/bill-manager")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getBillList(BillRequest billRequest) {
        return new ResponseEntity(billService.findAll(billRequest), HttpStatus.OK);
    }


}
