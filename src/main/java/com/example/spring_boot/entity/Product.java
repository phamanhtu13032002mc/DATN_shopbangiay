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
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;

    private Double price;//giá gốc

    private Double discount;//giảm %

    @Length(max = 5000)
    private String description;//mô tả

    @Length(max = 5000)
    private String descriptionDetail;//mô tả chi tiết

    private String status;//trạng thái

    private Date date_update;
    private Date date_create;
    private String image;//hình ảnh

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "id_image")
    private Image images;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Productdetail> productdetails;
}
