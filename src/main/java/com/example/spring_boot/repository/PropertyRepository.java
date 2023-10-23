package com.example.spring_boot.repository;

import com.example.spring_boot.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<PropertyEntity,Long> {

    @Query(value = "SELECT * FROM property WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<PropertyEntity> findAllByIsDeleteFase();

    Optional<PropertyEntity> findByName(String name);


}
