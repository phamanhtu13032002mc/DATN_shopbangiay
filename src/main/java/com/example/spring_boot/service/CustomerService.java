package com.example.spring_boot.service;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CustomerRequest;
import org.springframework.data.domain.Page;

public interface CustomerService {

    Page<CustomerEntity> findAllCustomer(CustomerRequest customerRequest);

    Object create(CustomerRequest customerRequest);

    Object detele(CustomerRequest customerRequest);

    Object update(CustomerRequest customerRequest);

    Object findByNameLike(CustomerRequest customerRequest);

    DataObj findCustomerByIdUser(Long idUser);
}
