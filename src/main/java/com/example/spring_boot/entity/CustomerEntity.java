package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;


    @Column(name = "email")
    private String email;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @JsonIgnore
    @OneToMany(mappedBy = "customerEntity")
    private List<BillEntity> billEntities;

    @ManyToOne()
    @JoinColumn(name = "idUser")
    private UserEntity userEntity;


}
