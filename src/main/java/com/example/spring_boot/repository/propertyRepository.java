package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.ERole;
import com.example.spring_boot.entity.Property;
import com.example.spring_boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface propertyRepository extends JpaRepository<Property,Long> {

    @Query(value = "SELECT * FROM property WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<Property> findAllByIsDeleteFase();

    Optional<Property> findByName(String name);


}
