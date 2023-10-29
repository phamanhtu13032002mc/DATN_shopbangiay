package com.example.spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orderdetail")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;//giá gốc
    private Double intoMoney;//thành tiền
    private Double downPrice;//giá giảm
    private Long quantity_oder;//số lượng mua

    @Column(name = "isDelete")
    @Builder.Default
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "id_bill", updatable = false, insertable = false)
    private BillEntity billEntity;

    @OneToMany(mappedBy = "oderDetailEntities")
    private List<ProductDetailEntity> productDetailEntities;


}
