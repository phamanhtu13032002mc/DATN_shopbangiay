package com.example.spring_boot.config;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.CreateBillManger;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import com.example.spring_boot.repository.BillRepository;

import java.util.List;
import java.util.Map;

public class GHNConfig {
    public static String GHN_URL = "https://dev-online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/create";
    public static  String GHN_Token = "b7ac65a4-b2fc-11ee-8026-f29d8335aebb";


}
