package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    @JoinColumn(name = "id_product",  updatable = false, insertable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "id_property", updatable = false, insertable = false)
    private PropertyEntity propertyEntity;


    @Column(name = "isDelete")
    private Boolean isDelete = false;

    private Long size;

    @ManyToOne
    @JoinColumn(name = "productDetail")
    private OderDetailEntity oderDetailEntities;


}
