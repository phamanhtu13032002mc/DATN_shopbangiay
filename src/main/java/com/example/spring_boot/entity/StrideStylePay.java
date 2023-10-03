package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "stridestylepay")
public class StrideStylePay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double surplus;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idcustomer", updatable = false, insertable = false)
    private Customer customer;

    @Column(name = "idcustomer")
    private Long idcustomer;


}
