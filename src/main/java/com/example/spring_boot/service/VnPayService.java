package com.example.spring_boot.service;

import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.UrlVnpayRequest;

import javax.servlet.http.HttpServletRequest;

public interface VnPayService {
      DataObj getUrlVnp(UrlVnpayRequest urlVnpayRequest);
      DataObj ReturnURL(HttpServletRequest request);
}
