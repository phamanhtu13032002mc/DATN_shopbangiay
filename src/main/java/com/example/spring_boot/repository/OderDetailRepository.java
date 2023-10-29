package com.example.spring_boot.repository;

import com.example.spring_boot.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
}
