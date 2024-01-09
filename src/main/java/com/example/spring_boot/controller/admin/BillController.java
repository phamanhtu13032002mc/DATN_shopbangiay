package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.*;
import com.example.spring_boot.service.BillService;
import com.example.spring_boot.service.OrderDetailService;
import com.example.spring_boot.service.impl.EmailServiceImpl;
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
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    EmailServiceImpl emailService;

    @PostMapping(value = "/create-bill")
    public  ResponseEntity<?> createBill(@RequestBody CreateBillManger createBillManger){

        return  ResponseEntity.ok(billService.create(createBillManger));
    }
    @PostMapping(value = "/create-bill-off")
    public  ResponseEntity<?> createBillOff(@RequestBody CreateBillMangerOff createBillManger){

        return  ResponseEntity.ok(billService.createOff(createBillManger));
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
    @PostMapping(value = "/find-all-by-id-customer")
    public ResponseEntity<?> findAllByIdCustomer(
            @RequestBody FindIdByCustomer findIdByCustomer) {
        return ResponseEntity.ok(billService.findAllByIdCustomer(findIdByCustomer));
    }
    @GetMapping(value = "/find-by-id_bill/{idBill}")
    public ResponseEntity<?> findByIdBill(@PathVariable("idBill") Long idBill){
        return ResponseEntity.ok(billService.findByIdBill(idBill));
    }
    @PostMapping(value = "/send-mail")
    public ResponseEntity<?> sendMail(@RequestBody CustomerRequest customerRequest) {
        try {
            emailService.sendCreateBill(customerRequest);
            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
}
    }

    @GetMapping("/revenue-for-current-month")
    public ResponseEntity<?> getRevenueStatisticsForCurrentMonth() {
        return ResponseEntity.ok(billService.getRevenueStatisticsForCurrentMonth());
    }

    @GetMapping("/count-status-daylly")
    public ResponseEntity<?> getCountStatusDaily(){
            return ResponseEntity.ok(billService.getStatusDaily());
    }
}
