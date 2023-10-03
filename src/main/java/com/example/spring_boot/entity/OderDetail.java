package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orderdetail")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;//giá gốc
    private Double intomoney;//thành tiền
    private Double downprice;//giá giảm
    private Long quantity_oder;//số lượng mua
    @Column(name = "isDelete")
    @Builder.Default
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "id_product_detail")
    private Productdetail productdetail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idbill", updatable = false, insertable = false)
    private Bill bill;

    @Column(name = "idbill")
    private String idbill;

}
