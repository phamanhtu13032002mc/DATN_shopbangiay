package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.EnumShipping;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class CreateBillManger {

    private EnumShipping status;

    private String transportFee;

    private Long voucherId;
    private Double discount;
    private Double downTotal;
    private Boolean payment;

    private Double total;

    private String address;

    private String note;

    private String fullName;

    private String phoneNumber;

    private String noteRefund;

    private Long idCustomer;
    private Boolean salesStatus;
    private List<OrderDetailRequest> orderDetailRequests;
}
