package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Property;
import com.example.spring_boot.entity.Size;

import java.util.List;
import java.util.Optional;

public interface SizeService {

    List<Size> findAll();

    Size save(Size size);

    List<Size> findAllByIsDeleteFalse();

    void delete(Long id);

    Optional<Size> findByID(Long id);

}
