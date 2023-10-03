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

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "productdetail")
    private List<Property> properties;

    @ManyToMany
    @JoinTable(name = "productdetail",
            joinColumns = @JoinColumn(name = "productdetail"),
            inverseJoinColumns = @JoinColumn(name = "size"))
    private Set<Size> size;

    @JsonIgnore
    @OneToMany(mappedBy = "productdetail")
    private List<OderDetail> oderDetails;


}
