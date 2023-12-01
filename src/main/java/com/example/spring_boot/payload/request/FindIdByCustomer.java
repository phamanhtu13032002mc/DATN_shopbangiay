package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindIdByCustomer {
    private int id_customer;
    private int page;
    private int size;
}
