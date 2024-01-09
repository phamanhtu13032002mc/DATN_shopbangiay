package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.CustomerRequest;
import com.example.spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @PostMapping(value = "/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.create(customerRequest));
    }
    @PostMapping ("/delete")
    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.detele(customerRequest));
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.update(customerRequest));
    }
    @PostMapping(value = "/find-by-name-like")
    public ResponseEntity<?> findByNameLike(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.findByNameLike(customerRequest));
    }

    @GetMapping("/find-customer-by-user/{idUser}")
    public ResponseEntity<?> findByUserId(@PathVariable("idUser") Long idUser){
        return ResponseEntity.ok(customerService.findCustomerByIdUser(idUser));
    }
}
