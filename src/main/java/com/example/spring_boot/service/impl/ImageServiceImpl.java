package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.request.ImageRequest;
import com.example.spring_boot.repository.ImageRepository;
import com.example.spring_boot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Override
    public List<ImageEntity> findAll(ImageRequest imageRequest) {
        return imageRepository.findAll();
    }

    @Override
    public Optional<ImageEntity> findByID(Long id) {
        return imageRepository.findById(id);
    }
}
