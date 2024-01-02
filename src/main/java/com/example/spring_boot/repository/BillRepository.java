package com.example.spring_boot.repository;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.EnumShipping;
import com.example.spring_boot.payload.response.BillStatusShipping;
import com.example.spring_boot.payload.response.Statistical;
import com.example.spring_boot.payload.response.statisticalResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

    @Query(value = "SELECT * FROM bill WHERE id = ?", nativeQuery = true)
    BillEntity findByidBill(Long id);

    @Query(value = "SELECT b, v, c, o FROM BillEntity b " +
            "LEFT JOIN VoucherEntity v ON b.voucherId = v.id " +
            "LEFT JOIN CustomerEntity c ON b.customerEntity.id = c.id " +
            "LEFT JOIN OrderDetailEntity o ON o.billEntity.id = b.id " +
            "WHERE  b.customerEntity.fullName  LIKE %:name% " +
            "GROUP BY b.id")
    Page<Object> findByNameLike(String name, Pageable pageable);


    @Query("SELECT b " +
            "FROM BillEntity b " +
            "JOIN b.oderDetailEntities " +
            "LEFT JOIN b.voucherEntities " +
            "LEFT JOIN b.customerEntity  " +
            "WHERE (:startDate IS NULL OR b.createAt = :startDate) " +
            "AND (:phone IS NULL OR b.sdt LIKE CONCAT('%', :phone, '%')) " +
            "AND (:email IS NULL OR b.fullName LIKE CONCAT('%', :email, '%')) " +
            "AND (:statusShipping IS NULL OR b.statusShipping = :statusShipping) " +
            "AND (:payment IS NULL OR b.payment = :payment) " +
            "GROUP BY b.id")
    Page<Object> findAllBill(
            @Param("startDate") LocalDate startDate,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("statusShipping") EnumShipping statusShipping,
            @Param("payment") Integer payment,
            Pageable pageable
    );


    @Query(value = "SELECT b " +
            "FROM BillEntity b " +
            "JOIN b.oderDetailEntities " +
            "LEFT JOIN b.voucherEntities " +
            "LEFT JOIN b.customerEntity  " +
            "WHERE  " +
            "b.id = :idBill")
    Object findBillById(Long idBill);

    @Query("SELECT NEW com.example.spring_boot.payload.response.BillStatusShipping(" +
            "SUM(CASE WHEN b.statusShipping = 0 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN b.statusShipping = 1 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN b.statusShipping = 2 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN b.statusShipping = 3 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN b.statusShipping = 4 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN b.statusShipping = 5 THEN 1 ELSE 0 END)) " +
            "FROM BillEntity b")
    List<BillStatusShipping> NumberOfOrderStatuses();

    @Query("SELECT DAY(b.createAt) as Date, SUM(b.downTotal) AS Sum  " +
            "FROM BillEntity b " +
            "WHERE MONTH(b.createAt) = 12 " +
            "  AND YEAR(b.createAt) = 2023 " +
            "GROUP BY DAY(b.createAt) " +
            "ORDER BY DAY(b.createAt)")
    List<Statistical> statistical();



}
