package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "property")
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproperty;

    private String name;

    @Column(name = "isDelete")
    private Boolean isDelete = false;


    @ManyToOne
    @JoinColumn(name = "productdetail")
    private Productdetail productdetail;
}
