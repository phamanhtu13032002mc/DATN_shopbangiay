package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity,Long> {

}
