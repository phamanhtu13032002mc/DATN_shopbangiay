package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "size")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToMany(mappedBy = "size")
    private Set<Productdetail> productdetail = new HashSet<>();
}
