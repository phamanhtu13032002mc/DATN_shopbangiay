package com.example.spring_boot.config;

import com.example.spring_boot.payload.request.UrlVnpayRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Vnpayconfig {
    public static String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";
    public static String vnp_ReturnUrl = "http://localhost:8081/checkout-done";

    public static String vnp_TmnCode = "I4RD1EH4";
    public static String vnp_HashSecret = "UGBYTNGICAHVQZODUHNPGOGYQUTPKUMB";
    public static String vnp_apiUrl = "https://sandbox.vnpayment.vn/merchant_webapi/api/transaction";

    public static String getUrl( String emailNguoiNhann,
                                 BigDecimal tienGiamGia,
                                 String nameGiamGia,
                                 String sdtNguoiNhan,
                                 BigDecimal tienShipHD,
                                 long hoaDonId,
                                 long idNguoiDung){
//        vnp_ReturnUrl = vnp_ReturnUrl
//                + "emailNguoiNhann=" + emailNguoiNhann + "&tienGiamGia=" + tienGiamGia + "&nameGiamGia="
//                + nameGiamGia + "&sdtNguoiNhan=" + sdtNguoiNhan + "&tienShipHD="
//                + tienShipHD + "&hoaDonId=" + hoaDonId + "&nguoiDungId=" + idNguoiDung;
        return vnp_ReturnUrl;
    }
    public static String hmacSHA512(final String key, final String data) {
        try {

            if (key == null || data == null) {
                throw new NullPointerException();
            }
            final Mac hmac512 = Mac.getInstance("HmacSHA512");
            byte[] hmacKeyBytes = key.getBytes();
            final SecretKeySpec secretKey = new SecretKeySpec(hmacKeyBytes, "HmacSHA512");
            hmac512.init(secretKey);
            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            byte[] result = hmac512.doFinal(dataBytes);
            StringBuilder sb = new StringBuilder(2 * result.length);
            for (byte b : result) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "lỗi mã hóa";
        }
    }
    public static String getRandomNumber(int len) {
        Random rnd = new Random();
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
