package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity implements Serializable {
    @Id
    private String id;

    @Column(name = "status")
    private String statusShipping;//tình trạng giao hàng

    @Column(name = "transport_fee")
    private Double transportFee;//phí vận chuyển

    @Column(name = "voucher_id")
    private Long voucherId;//mã voucher

    private Double discount; // giảm giá

    private Double downTotal;// giá sau khi giảm

    private Boolean payment;// thanh toán bằng gì flase mua hàng r thanh toán, true thanh toán bằng ví

    private Double total;//thanh toán

    private String sale_point;//điểm bán hàng

    private String address;//địa chỉ

    private String note;//ghi chú

    @OneToMany(mappedBy = "billEntity")
    List<OderDetailEntity> oderDetailEntities;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "update_at")
    private LocalDate updateAts;

    @Column(name = "full_name")
    private String fullName;//họ tên nhận hàng

    @Column(name = "phone_number")
    private String sdt;

    @Column(name = "refund")
    private String refund;

    @Column(name = "note_refund")
    @Length(max = 2000)
    private String noteRefund;

    @ManyToOne
    @JoinColumn(name = "id_customer", updatable = false, insertable = false)
    private CustomerEntity customerEntity;


    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @Column(name = "id_ward")
    private Long idWard;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_history_pay", updatable = false, insertable = false)
    private HistoryPayEntity historyPayEntity;

    @OneToMany(mappedBy = "billEntity")
    private List<VoucherEntity> voucherEntities;



}
