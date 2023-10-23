package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.UserEntity;
import com.example.spring_boot.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/account-manager")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getUserList() {
        return new  ResponseEntity(accountService.findByisDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {

        return new  ResponseEntity(accountService.findByID(id), HttpStatus.OK);
    }
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") long id) {
        return new  ResponseEntity(accountService.delete(id), HttpStatus.OK);
    }
        @PostMapping(value = "/update/{id}")
        public ResponseEntity<?> updateAccount(@RequestBody UserEntity userEntity) {
        return new  ResponseEntity(accountService.save(userEntity), HttpStatus.OK);
    }
}
