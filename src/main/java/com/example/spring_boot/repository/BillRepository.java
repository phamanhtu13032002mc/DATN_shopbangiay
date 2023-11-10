package com.example.spring_boot.repository;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.payload.request.BillRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    @Query(value = "SELECT * FROM bill WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<BillEntity> findAllBill(BillRequest billRequest, Pageable pageable);

    @Query(value = "SELECT * FROM bill WHERE id = ?",nativeQuery = true)
    BillEntity findByidBill(Long id);
}
