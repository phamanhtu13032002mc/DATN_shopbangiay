package com.example.spring_boot.service;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.request.EventRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EventService {




    Optional<EventEntity> findByID(long id);

    Page<EventEntity> findAllEvent(EventRequest eventRequest);


    EventEntity create(EventRequest eventRequest);


    EventEntity detele(Long id);

    EventEntity update(Long id, EventRequest eventRequest);
}
