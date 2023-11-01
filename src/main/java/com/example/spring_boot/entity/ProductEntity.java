package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;
    private Double price;
    private Double discount;
    private String image;

    @Length(max = 5000)
    private String description;

    @Length(max = 5000)
    private String descriptionDetail;

    private String status;
    private Date date_update;
    private Date date_create;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @JsonIgnore
    @OneToMany(mappedBy = "productEntity")
    private List<ImageEntity> idImages;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;

    @JsonIgnore
    @OneToMany(mappedBy = "idProduct")
    private List<ProductDetailEntity> productEntity;
}

