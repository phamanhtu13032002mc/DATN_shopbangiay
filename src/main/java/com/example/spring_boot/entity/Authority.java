package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "authority")
    List<Roles> role;
}
