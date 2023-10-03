package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "image")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;
    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "image")
    List<Product> products;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "idproduct")
//    private Product product;
}
