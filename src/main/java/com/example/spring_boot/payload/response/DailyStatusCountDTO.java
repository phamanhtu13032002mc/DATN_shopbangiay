package com.example.spring_boot.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DailyStatusCountDTO {
    private LocalDate date;
    private Long huyCount;
    private Long khachDaNhanHangCount;

    public DailyStatusCountDTO(LocalDate date, Long huyCount, Long khachDaNhanHangCount) {
        this.date = date;
        this.huyCount = huyCount;
        this.khachDaNhanHangCount = khachDaNhanHangCount;
    }
}
