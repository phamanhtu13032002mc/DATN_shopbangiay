package com.example.spring_boot.service;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BillService {



    DataObj create(CreateBillManger createBillManger);
    DataObj createOff(CreateBillMangerOff createBillManger);

    DataObj updateBillCustomer(UpdateBillCustomer updateBillCustomer);

    DataObj cancelBillCustomer(UpdateBillCustomer updateBillCustomer);

    DataObj cancelBillManager(BillManager billManager);

    DataObj confirmBillManager(BillRequest billRequest);

    Object findByNameLike(BillRequest billRequest);

    Object findByDatePhoneStatus(SearchBill searchBill);

    Object findAllByIdCustomer(FindIdByCustomer findIdByCustomer);

    Object findByIdBill(Long idBill);
    DataObj NumberOfOrderStatuses();
}
