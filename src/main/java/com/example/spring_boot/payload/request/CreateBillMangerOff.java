package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.EnumShipping;
import lombok.Data;

import java.util.List;

@Data
public class CreateBillMangerOff {

    private Long voucherId;
    private Double discount;
    private Double downTotal;
    private int payment;

    private Double total;

    private String note;

    private String fullName;

    private String phoneNumber;

    private String noteRefund;

    private List<OrderDetailRequest> orderDetailRequests;
}
