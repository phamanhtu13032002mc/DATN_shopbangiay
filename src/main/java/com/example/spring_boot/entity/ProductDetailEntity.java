package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "product_detail")
public class ProductDetailEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "id_product", updatable = false, insertable = false)
    private ProductEntity productEntity;


    @OneToMany(mappedBy = "productDetail")
    private List<PropertyEntity> propertyEntity;


    @Column(name = "isDelete")
    private Boolean isDelete = false;

    private Long size;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderDetailEntity oderDetailEntities;


}
