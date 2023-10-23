package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "property")
public class PropertyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProperty;

    private String name;

    @Column(name = "isDelete")
    private Boolean isDelete = false;


    @ManyToOne
    @JoinColumn(name = "productDetail")
    private ProductDetailEntity productdetail;
}
