package com.example.spring_boot.controller.admin;


import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
import com.example.spring_boot.repository.VoucherRepository;
import com.example.spring_boot.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/voucher-manager")
public class VoucherController {

    @Autowired
    VoucherRepository voucherRepository;
    @Autowired
    VoucherService voucherService;
    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getVoucherList(
            @RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.findAllVoucher(voucherRequest));
    }
    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<?> getVoucherById(@PathVariable("id") long id) {

        return new  ResponseEntity(voucherService.findByID(id), HttpStatus.OK);
    }
   @GetMapping(value = "/get-by-evwnt/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") long id) {

        return new  ResponseEntity(voucherRepository.findByIdEven(id), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> createCategory(@RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.create(voucherRequest));
    }
    @PostMapping ("/delete")
    public ResponseEntity<?> deleteCategory(@RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.detele(voucherRequest));
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateCategory(@RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.update(voucherRequest));
    }
    @PostMapping(value = "/find-by-name-like")
    public ResponseEntity<?> findByNameLike(@RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.findByNameLike(voucherRequest));
    }
}
