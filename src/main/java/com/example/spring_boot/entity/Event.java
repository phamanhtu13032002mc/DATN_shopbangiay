package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date startday = new Date();

    private Date endday;

//	@Builder.Default
//	private Boolean status = false;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

//	@JsonIgnore
//	@OneToMany(mappedBy = "event")
//	private List<ImageEvent> imageevents;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<Voucher> vouchers;
}
