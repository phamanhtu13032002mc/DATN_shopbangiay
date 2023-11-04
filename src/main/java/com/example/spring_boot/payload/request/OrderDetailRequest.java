package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequest {
    private Long id;
    private Double price;//giá gốc

    private Double intoMoney;//thành tiền

    private Double downPrice;//giá giảm

    private Long quantity_oder;//số lượng mua
    private Long id_bill;
    private Long product_id;
    private int page;
    private int size;

}
