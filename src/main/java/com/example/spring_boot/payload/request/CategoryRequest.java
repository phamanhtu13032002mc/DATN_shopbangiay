package com.example.spring_boot.payload.request;

import com.example.spring_boot.entity.CategoryEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest  {
    private  Long id;
    private String name;
    private Double gender;
    private int page;
    private int size;
    private CategoryRequest categoryRequest;

}
