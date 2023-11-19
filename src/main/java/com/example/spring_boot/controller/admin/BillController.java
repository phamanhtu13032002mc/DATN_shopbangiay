package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.*;
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

    @PostMapping(value = "/create-bill")
    public  ResponseEntity<?> createBill(@RequestBody BillRequest billRequest){
        return  ResponseEntity.ok(billService.create(billRequest));
    }
    @PostMapping(value = "/update-bill-customer")
    public  ResponseEntity<?> updateBillCustomer(@RequestBody UpdateBillCustomer updateBillCustomer){
        return  ResponseEntity.ok(billService.updateBillCustomer(updateBillCustomer));
    }
    @PostMapping(value = "/cancel-bill-customer")
    public  ResponseEntity<?> cancelBillCustomer(@RequestBody UpdateBillCustomer updateBillCustomer){
        return  ResponseEntity.ok(billService.cancelBillCustomer(updateBillCustomer));
    }

    @PostMapping(value = "/cancel-bill-manager")
    public  ResponseEntity<?> cancelBillManager(@RequestBody BillManager billManager){
        return  ResponseEntity.ok(billService.cancelBillManager(billManager));
    }
    @PostMapping(value = "/confirm-bill-manager")
    public  ResponseEntity<?> confirmBillManager(@RequestBody BillRequest billRequest){
        return  ResponseEntity.ok(billService.confirmBillManager(billRequest));
    }
    @PostMapping(value = "/find-by-name-like")
    public ResponseEntity<?> findByNameLike(
            @RequestBody BillRequest billRequest) {
        return ResponseEntity.ok(billService.findByNameLike(billRequest));
    }
    @PostMapping(value = "/find-by-date-phone-email-status")
    public ResponseEntity<?> findByDatePhoneStatus(
            @RequestBody SearchBill searchBill) {
        return ResponseEntity.ok(billService.findByDatePhoneStatus(searchBill));
    }






}
