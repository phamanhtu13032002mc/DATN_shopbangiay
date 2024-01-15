package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "voucher")
public class VoucherEntity implements Serializable {
    @Id
    private Long id;

    private Long amount;

    private Double discount;

    @Column(name = "name")
    private String name;

    @Column(name = "minimumValue")
    private Double minimumValue;

    @JsonIgnore
    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private EventEntity eventEntity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private BillEntity billEntity;

}
