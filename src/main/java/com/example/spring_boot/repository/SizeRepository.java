package com.example.spring_boot.repository;

import com.example.spring_boot.entity.SizeEntity;
import com.example.spring_boot.payload.request.SizeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SizeRepository extends JpaRepository<SizeEntity,Long> {
    @Query(value = "SELECT * FROM size WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<SizeEntity> findAllProduct(SizeRequest sizeRequest, Pageable pageable);
}
