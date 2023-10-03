package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    @Id
    private String id;

    @Column(name = "status")

    private String statusshipping;//tình trạng giao hàng

    @Column(name = "transport_fee")
    private Double transportFee;//phí vận chuyển

    @Column(name = "voucher_id")
    private Long voucher_id;//mã voucher

    private Double discount; // giảm giá

    private Double downtotal;// giá sau khi giảm

    private Boolean payment;// thanh toán bằng gì flase mua hàng r thanh toán, true thanh toán bằng ví

    private Double total;//thanh toán

    private String sale_point;//điểm bán hàng

    @Length(max = 1000)
    private String address;//địa chỉ

    @Length(max = 1000)
    private String note;//ghi chú

    @Column(name = "create_at")
    private Date createAt = new Date();

    @Column(name = "update_at")
    private Date updateAts = new Date();

    @Column(name = "full_name")
    private String fullname;//họ tên nhận hàng

    @Column(name = "phone_number")
    private String sdt;

    @Column(name = "refund")
    private String refund;

    @Column(name = "note_refund")
    @Length(max = 2000)
    private String noterefund;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idcustomer", updatable = false, insertable = false)
    private Customer customer;

    @Column(name = "idcustomer")
    private Long idCustomer;

    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @Column(name = "id_ward")
    private Long idward;

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    List<OderDetail> oderDetails;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_historypay", updatable = false, insertable = false)
    private HistoryPay historyPay;


}
