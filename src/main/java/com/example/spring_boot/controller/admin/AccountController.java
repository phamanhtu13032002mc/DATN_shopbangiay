package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.User;
import com.example.spring_boot.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/AccountManager")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getUserList() {
        return new  ResponseEntity(accountService.findByisDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "Account/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {

        return new  ResponseEntity(accountService.findByID(id), HttpStatus.OK);
    }
    @GetMapping(value = "AccountDelete/{id}")
    public ResponseEntity<?> DeleteAccount(@PathVariable("id") long id) {
        return new  ResponseEntity(accountService.delete(id), HttpStatus.OK);
    }

        @PostMapping(value = "AccountUpdate/{id}")
        public ResponseEntity<?> UpdateAccount(@RequestBody User user) {
        return new  ResponseEntity(accountService.save(user), HttpStatus.OK);
    }
}
