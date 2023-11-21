package com.example.spring_boot.repository;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
    @Query(value = "SELECT * FROM orderdetail WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<OrderDetailEntity> findAllOderDetail(OrderDetailRequest oderDetailRequest, Pageable pageable);

    @Query(value = "SELECT * FROM orderdetail od WHERE od.id = ?",nativeQuery = true)
    OrderDetailEntity findByidOrOrderById(Long id);

//    @Query(value = "SELECT U FROM OrderDetailEntity U WHERE U.billEntity = :idBill")
    @Query(value = "SELECT * FROM orderdetail WHERE orderdetail.id_bill = ?",nativeQuery = true)
    Page<OrderDetailEntity> findByIdBill (@Param("idBill") Long idBill,Pageable pageable);

}
