package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.entity.HistoryPayEntity;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.HistoryPayRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
import com.example.spring_boot.service.HistoryPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/history-pay-manager")
public class HistoryPayController {
    @Autowired
    HistoryPayService historyPayService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getHistoryPayList(
            @RequestBody HistoryPayRequest historyPayRequest) {
        return ResponseEntity.ok(historyPayService.findAllHistoryPay(historyPayRequest));
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getHistoryPayById(@PathVariable Long id) {
        Optional<HistoryPayEntity> historyPayRequest = historyPayService.findByID(id);

        if (historyPayRequest.isPresent()) {
            return new ResponseEntity(historyPayRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
