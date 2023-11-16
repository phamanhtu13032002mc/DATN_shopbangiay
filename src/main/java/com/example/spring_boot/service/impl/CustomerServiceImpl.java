package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CustomerRequest;
import com.example.spring_boot.repository.CustomerRepository;
import com.example.spring_boot.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<CustomerEntity> findAllCustomer(CustomerRequest customerRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(customerRequest.getPage()), Math.toIntExact(customerRequest.getSize()));
        return customerRepository.findAllCustomer(customerRequest, pageable);
    }

    @Override
    public Object create(CustomerRequest customerRequest) {
        try {
            if (customerRequest.getFullName() == null){
                return new DataObj().setEdesc("full name  not null !!!");
            }
            if (customerRequest.getAddress() == null){
                return new DataObj().setEdesc("address not null !!!");
            }
            if (customerRequest.getPhone() == null){
                return new DataObj().setEdesc("phone not null !!!");
            }
            if (customerRequest.getEmail() == null){
                return new DataObj().setEdesc("phone not null !!!");
            }
            if (customerRequest.getId_address() == null){
                return new DataObj().setEdesc("id_address not null !!!");
            }

            else {
                CustomerEntity customer = new CustomerEntity();
                customer.setFullName(customerRequest.getFullName());
                customer.setAddress(customerRequest.getAddress());
                customer.setPhone(customerRequest.getPhone());
                customer.setEmail(customerRequest.getEmail());
                return new DataObj().setEcode("200").setEdesc("Create Complete").setData(customerRepository.save(customer));

            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi Customer");
        }
    }

    @Override
    public Object detele(CustomerRequest customerRequest) {
        try {
            Optional<CustomerEntity> customerOptional = customerRepository.findById(customerRequest.getId());
            if (customerOptional.isEmpty()) {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            } else {
                CustomerEntity customer = customerOptional.get();
                customer.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(customerRepository.save(customer));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }

    @Override
    public Object update(CustomerRequest customerRequest) {
        try {
            Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerRequest.getId());
            if (optionalCustomer.isPresent()) {
                CustomerEntity customer = optionalCustomer.get();
                customer.setFullName(customerRequest.getFullName());
                customer.setAddress(customerRequest.getAddress());
                customer.setPhone(customerRequest.getPhone());
                customer.setEmail(customerRequest.getEmail());
                return new DataObj().setEcode("200").setEdesc("Success").setData(customerRepository.save(customer));
            } else {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi update");
        }
    }
}
