package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "role")
public class Roles {
    @Id
    String id;
    String name;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "role")
    private Authority authority;
}
