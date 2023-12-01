package com.example.spring_boot.service;

import com.example.spring_boot.payload.request.UrlVnpayRequest;

public interface VnPayService {
      String getUrlVnp(UrlVnpayRequest urlVnpayRequest);
}
