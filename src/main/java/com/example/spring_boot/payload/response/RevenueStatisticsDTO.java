package com.example.spring_boot.payload.response;
import java.time.LocalDate;

public class RevenueStatisticsDTO {
    private LocalDate date;
    private Double totalRevenue;

    public RevenueStatisticsDTO(LocalDate date, Double totalRevenue) {
        this.date = date;
        this.totalRevenue = totalRevenue;
    }

    // Getter và Setter
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
