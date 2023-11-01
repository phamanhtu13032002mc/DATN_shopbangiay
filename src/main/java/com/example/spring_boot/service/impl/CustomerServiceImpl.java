package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.payload.request.CustomerRequest;
import com.example.spring_boot.repository.CustomerRepository;
import com.example.spring_boot.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<CustomerEntity> findAllCustomer(CustomerRequest customerRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(customerRequest.getPage()), Math.toIntExact(customerRequest.getSize()));
        return customerRepository.findAllCustomer(customerRequest, pageable);
    }
}
