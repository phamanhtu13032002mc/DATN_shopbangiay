package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.EnumShipping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchBill {
    private LocalDate startDate;
    private LocalDate dateTo;
    private String phone;
    private String email;
    private EnumShipping statusShipping;
    private int page;
    private int size;



}
