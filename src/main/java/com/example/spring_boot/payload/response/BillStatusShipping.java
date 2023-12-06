package com.example.spring_boot.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BillStatusShipping {
   private Long chuaXacNhan;
   private Long daXacNhanVaDongGoi;
   private Long daGiaoBenVanChuyen;
   private Long khachDaNhanHang;
   private Long hoanHang;
   private Long huy;
   public BillStatusShipping(Long chuaXacNhan, Long daXacNhanVaDongGoi, Long daGiaoBenVanChuyen, Long khachDaNhanHang, Long hoanHang, Long huy) {
      this.chuaXacNhan = chuaXacNhan;
      this.daXacNhanVaDongGoi = daXacNhanVaDongGoi;
      this.daGiaoBenVanChuyen = daGiaoBenVanChuyen;
      this.khachDaNhanHang = khachDaNhanHang;
      this.hoanHang = hoanHang;
      this.huy = huy;
   }
}
