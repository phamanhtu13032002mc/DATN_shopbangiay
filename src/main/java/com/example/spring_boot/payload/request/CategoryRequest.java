package com.example.spring_boot.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private String name;
    private Double gender;
    private int page;
    private int size;
    private CategoryRequest categoryRequest;

}
