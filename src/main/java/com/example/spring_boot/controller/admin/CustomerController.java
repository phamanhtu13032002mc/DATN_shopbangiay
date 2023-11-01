package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.CustomerRequest;
import com.example.spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

    @RequestMapping("/customer-manager")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getCustomerList(
            @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.findAllCustomer(customerRequest));
    }

}
