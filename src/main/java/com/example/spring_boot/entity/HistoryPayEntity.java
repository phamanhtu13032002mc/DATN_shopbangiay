package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "historyPay")
public class HistoryPayEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistory;

    private Long trading_code; //mã giao dịch

    private Double surplus;//số dư ví

    private String description;//nội dung giao dịch

    private LocalDate time;

    private Boolean status;

    private String title;//nạp tiền vào ví

    private Double amounts;


    @OneToOne
    @JoinColumn(name = "id_stride_style_pay", updatable = true, insertable = false)
    private StrideStylePayEntity strideStylePayEntity;


}
