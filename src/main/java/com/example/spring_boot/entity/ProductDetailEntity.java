package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", updatable = false, insertable = false)
    private ProductEntity idProduct;


    @ManyToOne
    @JoinColumn(name = "idProperty")
    private PropertyEntity idProperty;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private SizeEntity idSize;

    @Column(name = "isDelete")
    private Boolean isDelete = false;




}
