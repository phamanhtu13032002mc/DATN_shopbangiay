package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<EventEntity> findAllDeleteIsFalse();

    EventEntity save(EventEntity eventEntity);

    void delete(long id);

    Optional<EventEntity> findByID(long id);
}
