package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRequest {

    private Long amount;

    private Double discount;

    private String name;

    private Double minimumValue;
    private Long size;
    private Long page;
    private Long idEvent;

}
