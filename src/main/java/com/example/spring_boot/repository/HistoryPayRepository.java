package com.example.spring_boot.repository;

import com.example.spring_boot.entity.HistoryPayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryPayRepository extends JpaRepository<HistoryPayEntity,Long> {
}
