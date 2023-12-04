package com.example.spring_boot.service;

import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.request.FindImageByIdPrdRequest;
import com.example.spring_boot.payload.request.ImageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    Optional<ImageEntity> findByID(Long id);



    Page<ImageEntity> findAllImage(ImageRequest imageRequest);

    Object findImageByIdProduct(FindImageByIdPrdRequest findImageByIdPrdRequest);
}
