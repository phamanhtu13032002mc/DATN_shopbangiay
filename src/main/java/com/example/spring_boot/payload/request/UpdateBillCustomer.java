package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBillCustomer {
    private Long idBill;
    private String address;//địa chỉ

    private String note;//ghi chú

    private String fullname;//họ tên nhận hàng

    private String sdt;
}
