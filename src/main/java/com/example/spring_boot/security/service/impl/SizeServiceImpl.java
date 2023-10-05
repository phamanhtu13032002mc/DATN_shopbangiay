package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Size;
import com.example.spring_boot.repository.SizeRepository;
import com.example.spring_boot.security.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeRepository  sizeRepository;

    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size save(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public List<Size> findAllByIsDeleteFalse() {
        return sizeRepository.findAllByIsDeleteFase();
    }

    @Override
    public void delete(Long id) {
        Size size = sizeRepository.findById(id).get();
        size.setIsDelete(true);
        sizeRepository.save(size);


    }

    @Override
    public Optional<Size> findByID(Long id) {
        return sizeRepository.findById(id);
    }
}
