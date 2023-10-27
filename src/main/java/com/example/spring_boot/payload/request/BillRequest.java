package com.example.spring_boot.payload.request;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {

    @NotBlank
    private Long id;
    private String status;
    @NotBlank
    private String transport_fee;
    @NotBlank
    private Long voucher_id;
    private Double discount;
    private Double downTotal;
    private Boolean payment;

    private Double total;
    @NotBlank
    private String sale_point;
    @NotBlank
    private String address;

    private String note;
    @NotBlank
    private LocalDate create_at;
    @NotBlank
    private LocalDate update_at;

    private String full_name;

    private String phone_number;

    private String refund;

    @Size(max = 2000)
    private String note_refund;

}

