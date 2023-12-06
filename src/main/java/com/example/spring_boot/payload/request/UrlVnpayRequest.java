package com.example.spring_boot.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UrlVnpayRequest {
    long idCustomer;
    long total;
    String orderInfor;
    String emailNguoiNhann;
    BigDecimal tienGiamGia;
    String nameGiamGia;
    String sdtNguoiNhan;
    BigDecimal tienShipHD;
    Long hoaDonId;
    String nguoiNhan;
    String diaChiGiaoHang;
    String ghiChu;
}
