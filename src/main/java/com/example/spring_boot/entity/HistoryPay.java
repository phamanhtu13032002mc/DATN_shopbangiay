package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "historyPay")
public class HistoryPay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhistory;

    private Long trading_code; //mã giao dịch

    private Double surplus;//số dư ví

    private String description;//nội dung giao dịch

    private Date time;

    private Boolean status;

    private String title;//nạp tiền vào ví

    private Double amounts;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id", updatable = true, insertable = false)
    private StrideStylePay strideStylePay;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "historypay", updatable = false, insertable = false)
    private Bill bill;


}
