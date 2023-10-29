package com.example.spring_boot.service;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.EventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface EventService {


    List<EventEntity> findAllDeleteIsFalse();


    EventEntity save(EventEntity eventEntity);

    void delete(long id);

    Optional<EventEntity> findByID(long id);

    Page<EventEntity> findAll(PageRequest pageRequest);
}
