package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Property;
import com.example.spring_boot.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size,Long> {

    @Query(value = "SELECT * FROM size WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<Size> findAllByIsDeleteFase();

    Optional<Size> findByName(String name);

}
