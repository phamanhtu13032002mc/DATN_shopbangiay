package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    private Long id_event;
    private String name;

    private LocalDate startDay;

    private LocalDate endDay;
    private Long page;
    private Long size;

}
