package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.ProductDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequest {
    private long   orderDetailId;
    private long   productId;
    private String productName;
    private String  image;
    private  double price;
    private Long size;
    private Long page;
    private String property;
    private long  quantity;
    private long  idBill;
}
