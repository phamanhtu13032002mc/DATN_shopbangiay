package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Event;
import com.example.spring_boot.entity.Voucher;
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
    public List<Event> findAllDeleteIsFalse() {
        return eventRepossitory.findAllByIsDeleteFase();
    }

    @Override
    public Event save(Event event) {
        return eventRepossitory.save(event);
    }

    @Override
    public void delete(long id) {
        Event event  = eventRepossitory.findById(id).get();
        event.setIsDelete(true);
        eventRepossitory.save(event);

    }

    @Override
    public Optional<Event> findByID(long id) {
        return eventRepossitory.findById(id);
    }
}
