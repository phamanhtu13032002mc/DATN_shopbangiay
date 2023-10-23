package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "stride_style_pay")
public class StrideStylePayEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double surplus;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_customer", updatable = false, insertable = false)
    private CustomerEntity customerEntity;

    @Column(name = "id_customer")
    private Long idCustomer;


}
