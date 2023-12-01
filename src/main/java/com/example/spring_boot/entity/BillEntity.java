package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity implements Serializable {
    @Id
    private Long id;

    private EnumShipping statusShipping;//tình trạng giao hàng

    private Double transportFee;//phí vận chuyển

    private Long voucherId;//mã voucher

    private Double discount; // giảm giá

    private Double downTotal;// giá sau khi giảm

    private int payment;// thanh toán bằng gì flase mua hàng r thanh toán, true thanh toán bằng ví

    private Double total;//thanh toán

    private String sale_point;//điểm bán hàng

    private String address;//địa chỉ

    private String note;//ghi chú


    private LocalDate createAt;

    private LocalDate updateAts;

    private String fullName;//họ tên nhận hàng

    private String sdt;
    private Boolean salesStatus;

    @Length(max = 2000)
    private String noteRefund;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private CustomerEntity customerEntity;

    @JsonIgnore
    private Boolean isDelete = false;


    @OneToMany(mappedBy = "billEntity")
    private List<VoucherEntity> voucherEntities;

    @OneToMany(mappedBy = "billEntity")
    private List<OrderDetailEntity> oderDetailEntities;


}
