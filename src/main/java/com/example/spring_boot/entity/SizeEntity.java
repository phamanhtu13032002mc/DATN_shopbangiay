package com.example.spring_boot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "size")
public class SizeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "isDelete")
    private Boolean isDelete;

    @JsonIgnore
    @OneToMany(mappedBy = "idSize")
    private List<ProductDetailEntity> productDetailEntities;
}