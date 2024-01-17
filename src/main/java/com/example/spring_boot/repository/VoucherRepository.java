package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.request.VoucherRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoucherRepository extends JpaRepository<VoucherEntity,Long> {



    @Query("SELECT v  FROM VoucherEntity v " +
            "WHERE (:name IS NULL OR v.name LIKE CONCAT('%', :name, '%'))" +
            "AND v.isDelete = false ORDER BY v.id DESC")
    Page<VoucherEntity> findAllHistoryPay(@Param("name") String name, Pageable pageable);
    @Query("SELECT V FROM VoucherEntity V WHERE :name IS NULL OR V.name LIKE %:name%")
    Page<VoucherEntity> findByNameLike(String name, Pageable pageable);

    @Query(value = "SELECT vc FROM VoucherEntity vc WHERE vc.id = :id")
    VoucherEntity findByIdVoucher(@Param("id") Long id);
    @Query(value = "SELECT e FROM EventEntity e WHERE e.id_event = :id")
    EventEntity findByIdEven(@Param("id") Long id);
}
