package com.example.spring_boot.service.impl;

import com.example.spring_boot.config.Vnpayconfig;
import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.UrlVnpayRequest;
import com.example.spring_boot.repository.CustomerRepository;
import com.example.spring_boot.service.VnPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VnpayServiceImpl implements VnPayService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public DataObj getUrlVnp(UrlVnpayRequest urlVnpayRequest) {
        try {
            CustomerEntity customer = customerRepository.findByIdUser(urlVnpayRequest.getIdCustomer());
            long idNguoiDung = customer.getId();

            String vnp_Version = "2.1.0";
            String vnp_Command = "pay";
            String vnp_TxnRef = Vnpayconfig.getRandomNumber(8);
            String vnp_IpAddr = "127.0.0.1";
            String vnp_TmnCode = Vnpayconfig.vnp_TmnCode;
            String orderType = "order-type";

            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(urlVnpayRequest.getTotal() * 100));
            vnp_Params.put("vnp_CurrCode", "VND");

            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", urlVnpayRequest.getOrderInfor());
            vnp_Params.put("vnp_OrderType", orderType);

            String locate = "vn";
            vnp_Params.put("vnp_Locale", locate);

            vnp_Params.put("vnp_ReturnUrl", Vnpayconfig.getUrl(urlVnpayRequest.getEmailNguoiNhann(), urlVnpayRequest.getTienGiamGia(), urlVnpayRequest.getNameGiamGia(), urlVnpayRequest.getSdtNguoiNhan(), urlVnpayRequest.getTienShipHD(), urlVnpayRequest.getHoaDonId(), idNguoiDung));
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    try {
                        hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        //Build query
                        query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                        query.append('=');
                        query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = Vnpayconfig.hmacSHA512(Vnpayconfig.vnp_HashSecret, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = Vnpayconfig.vnp_PayUrl + "?" + queryUrl;
            return new DataObj().setEcode("200").setEdesc("Create Complete").setData(paymentUrl);
        }
        catch (Exception e){
            e.printStackTrace();
            return new DataObj().setEcode("420").setEdesc("Error");
        }

    }

    @Override
    public DataObj ReturnURL(HttpServletRequest request) {
        try {
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements(); ) {
                String fieldName = null;
                String fieldValue = null;
                try {
                    fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                    fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }

            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                return new DataObj().setEcode("200").setEdesc("Thành công").setData(0);
            } else {
                return new DataObj().setEcode("200").setEdesc("lỗi").setData(request.getParameter("vnp_TransactionStatus"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return new DataObj().setEcode("420").setEdesc("lỗi");

        }

    }
}
