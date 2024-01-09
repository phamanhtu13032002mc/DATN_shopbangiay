package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.request.ImageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity,Long> {
    @Query(value = "SELECT * FROM image WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<ImageEntity> findAllImage(ImageRequest imageRequest, Pageable pageable);

    @Query(value = "select i from ImageEntity i where i.productEntity.id = :idProduct")
    Page<ImageEntity> findByNameLike(Long idProduct, Pageable pageable);

    @Query(value = "select i from ImageEntity i where i.productEntity.id = :idProduct")
    List<ImageEntity> findByProductId(Long idProduct);
}
