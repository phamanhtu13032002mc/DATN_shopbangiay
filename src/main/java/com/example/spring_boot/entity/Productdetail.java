package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "product_detail")
public class Productdetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantity;

    @ManyToOne
    @JoinColumn(name = "idproduct",  updatable = false, insertable = false)
    private Product product;
    @Column(name = "idproduct")
    private Long idProduct;
    @ManyToOne
    @JoinColumn(name = "idproperty", updatable = false, insertable = false)
    private Property property;
    @Column(name = "idproperty")
    private Long idproperty;
    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "idSizes", updatable = false, insertable = false)
    private Size size;
    @Column(name = "idsize")
    private Long idsize;
    @JsonIgnore
    @OneToMany(mappedBy = "productdetail")
    private List<OderDetail> oderDetails;


}
