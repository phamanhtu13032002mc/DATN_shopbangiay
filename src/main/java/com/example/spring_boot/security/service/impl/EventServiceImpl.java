package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.repository.EventRepossitory;
import com.example.spring_boot.security.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepossitory eventRepossitory;

    @Override
    public List<EventEntity> findAllDeleteIsFalse() {
        return eventRepossitory.findAllByIsDeleteFase();
    }

    @Override
    public EventEntity save(EventEntity eventEntity) {
        return eventRepossitory.save(eventEntity);
    }

    @Override
    public void delete(long id) {
        EventEntity eventEntity = eventRepossitory.findById(id).get();
        eventEntity.setIsDelete(true);
        eventRepossitory.save(eventEntity);

    }

    @Override
    public Optional<EventEntity> findByID(long id) {
        return eventRepossitory.findById(id);
    }
}
