package com.example.spring_boot.repository;

import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<PropertyEntity,Long> {




    Optional<PropertyEntity> findByName(String name);

    @Query(value = "SELECT * FROM property WHERE is_delete = 0 ORDER BY id_property DESC",nativeQuery = true)
    Page<PropertyEntity> findAllProperties(PropertiesRequest propertiesRequest, Pageable pageable);
}
