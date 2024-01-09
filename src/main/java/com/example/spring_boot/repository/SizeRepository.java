package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.SizeEntity;
import com.example.spring_boot.payload.request.SizeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizeRepository extends JpaRepository<SizeEntity,Long> {
    @Query(value = "SELECT * FROM size WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<SizeEntity> findAllProduct(SizeRequest sizeRequest, Pageable pageable);
    @Query("SELECT S FROM SizeEntity S WHERE :name IS NULL OR S.name LIKE %:name%")
    Page<SizeEntity> findByNameLike(String name, Pageable pageable);

//    @Query(value = "select s from SizeEntity s where s.id =?1 ")
//    List<CategoryEntity> findBySizeID(Long id);

    boolean existsByName(String name);
}

