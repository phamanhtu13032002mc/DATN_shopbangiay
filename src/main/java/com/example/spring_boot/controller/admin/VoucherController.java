package com.example.spring_boot.controller.admin;


import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
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
//    @PostMapping(value = "/create")
//    public ResponseEntity<DataObj> createVoucher(@RequestBody VoucherRequest voucherRequest) {
//        return ResponseEntity.ok(new DataObj(voucherService.create(voucherRequest),"thêm thành công ",true));
//    }
//    @GetMapping("/delete/{id}")
//    public ResponseEntity<DataObj> deteleEvent(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(new DataObj(voucherService.detele(id), "Xóa thành công", true));
//    }
//    @PostMapping(value = "/update/{id}")
//    public ResponseEntity<DataObj> updateEvent(@PathVariable("id") Long id ,@RequestBody VoucherRequest voucherRequest) {
//        return ResponseEntity.ok(new DataObj(voucherService.update(id,voucherRequest),"update thành công ",true));
//    }
}
