package com.example.spring_boot.service;

import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.request.ImageRequest;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    List<ImageEntity> findAll(ImageRequest imageRequest);

    Optional<ImageEntity> findByID(Long id);
}
