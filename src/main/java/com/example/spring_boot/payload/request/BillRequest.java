package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.CustomerEntity;
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
    private String statusShipping;

    private String transport_fee;

    private Long voucher_id;
    private Double discount;
    private Double downTotal;
    private Boolean payment;

    private Double total;

    private String sale_point;

    private String address;

    private String note;

    private LocalDate create_at;

    private LocalDate update_at;

    private String fullName;

    private String phone_number;

    private String refund;

    private String note_refund;
    private int page;
    private int size;
    private Long idCustomer;
    private List<ProductDetailRequest> productDetail;
     private List<CustomerRequest> customerRequests;


}

