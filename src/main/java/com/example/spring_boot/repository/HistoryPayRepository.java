package com.example.spring_boot.repository;

import com.example.spring_boot.entity.HistoryPayEntity;
import com.example.spring_boot.payload.request.HistoryPayRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoryPayRepository extends JpaRepository<HistoryPayEntity,Long> {

    @Query(value = "SELECT * FROM history_pay  ORDER BY id_history DESC",nativeQuery = true)
    Page<HistoryPayEntity> findAllHistoryPay(HistoryPayRequest historyPayRequest, Pageable pageable);
}
