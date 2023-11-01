package com.example.spring_boot.service;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.EventRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EventService {




    Optional<EventEntity> findByID(long id);

    Page<EventEntity> findAllEvent(EventRequest eventRequest);


    DataObj create(EventRequest eventRequest);


    DataObj detele(EventRequest eventRequest);

    DataObj update( EventRequest eventRequest);
}
