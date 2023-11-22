package com.example.spring_boot.repository;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.EnumShipping;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.SearchBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

    @Query(value = "SELECT * FROM bill WHERE id = ?",nativeQuery = true)
    BillEntity findByidBill(Long id);

    @Query(value = "SELECT b, v, c, o FROM BillEntity b " +
            "LEFT JOIN VoucherEntity v ON b.voucherId = v.id " +
            "LEFT JOIN CustomerEntity c ON b.customerEntity.id = c.id " +
            "LEFT JOIN OrderDetailEntity o ON o.billEntity.id = b.id " +
            "WHERE  b.customerEntity.fullName  LIKE %:name% " +
            "GROUP BY b.id")
    Page<Object> findByNameLike(String name, Pageable pageable);


    @Query(value = "SELECT b " +
            "FROM BillEntity b " +
            "JOIN b.oderDetailEntities " +
            "LEFT JOIN b.voucherEntities "  +
            "LEFT JOIN b.customerEntity  " +
            "WHERE  (:startDate IS NULL OR  b.createAt >= :startDate ) " +
            "AND (:dateTo IS NULL OR  b.createAt <= :dateTo )"+
            "AND (:phone IS NULL OR b.customerEntity.phone = :phone)"+
            "AND (:email IS NULL OR b.customerEntity.email = :email)"+
            "AND (:statusShipping IS NULL OR b.statusShipping = :statusShipping)"+
            "GROUP BY b.id")
    Page<Object> findAllBill(
            LocalDate dateTo, LocalDate startDate, String phone, String email, String statusShipping, Pageable pageable
    );


    @Query(value = "SELECT b " +
            "FROM BillEntity b " +
            "JOIN b.oderDetailEntities " +
            "LEFT JOIN b.voucherEntities "  +
            "LEFT JOIN b.customerEntity  " +
            "WHERE  "+
            "b.id = :idBill")
    Object findBillById(Long idBill);



}
