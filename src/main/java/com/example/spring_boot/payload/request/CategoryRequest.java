package com.example.spring_boot.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;

    @NotBlank
    private Double gender;

    public String getName() {
        return name;
    }

    public Double getGender() {
        return gender;
    }

}
