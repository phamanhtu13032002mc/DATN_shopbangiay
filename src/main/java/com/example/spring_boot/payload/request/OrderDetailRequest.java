package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequest {
    private long orderDetailId;
    private long productId;
    private Long sizeId;
    private long propertyId;
    private String productName;
    private Long size;
    private Long page;
    private String property;
    private long quantity;
    private long idBill;
}
