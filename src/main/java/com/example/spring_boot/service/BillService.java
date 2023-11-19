package com.example.spring_boot.service;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BillService {



    DataObj create(CreateBillManger createBillManger);

    DataObj updateBillCustomer(UpdateBillCustomer updateBillCustomer);

    DataObj cancelBillCustomer(UpdateBillCustomer updateBillCustomer);

    DataObj cancelBillManager(BillManager billManager);

    DataObj confirmBillManager(BillRequest billRequest);

    Object findByNameLike(BillRequest billRequest);

    Object findByDatePhoneStatus(SearchBill searchBill);

    Object findAll(SearchBill searchBill);
}
