package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "event")
public class EventEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event;

    private String name;

    private LocalDate startDay;

    private Date endDay;

//	@Builder.Default
//	private Boolean status = false;

    @Column(name = "isDelete")
    private Boolean isDelete = false;



    @JsonIgnore
    @OneToMany(mappedBy = "eventEntity")
    private List<VoucherEntity> voucherEntities;

}
