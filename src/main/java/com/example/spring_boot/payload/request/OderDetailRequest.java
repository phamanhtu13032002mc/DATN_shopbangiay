package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderDetailRequest {
    @NotBlank
    private Double price;//giá gốc
    @NotBlank
    private Double intoMoney;//thành tiền

    private Double downPrice;//giá giảm
    @NotBlank
    private Long quantity_oder;//số lượng mua

}
