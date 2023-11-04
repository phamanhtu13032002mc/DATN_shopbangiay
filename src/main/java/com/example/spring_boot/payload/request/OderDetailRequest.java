package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderDetailRequest {

    private Double price;//giá gốc

    private Double intoMoney;//thành tiền

    private Double downPrice;//giá giảm

    private Long quantity_oder;//số lượng mua
    private int page;
    private int size;

}
