package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.EnumShipping;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {


    private Long idBill;
    private EnumShipping status;

    private String transportFee;

    private Long voucherId;
    private Double discount;
    private Double downTotal;
    private Boolean payment;

    private Double total;

    private String salePoint;

    private String address;

    private String note;

    private LocalDate createAt;

    private LocalDate updateAt;

    private String fullName;

    private String phoneNumber;

    private String refund;

    private String noteRefund;
    private int page;
    private int size;
    private Long idCustomer;
    private List<OrderDetailRequest> orderDetailRequests;


}

