package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Event;
import com.example.spring_boot.entity.Voucher;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAllDeleteIsFalse();

    Event save(Event event);

    void delete(long id);

    Optional<Event> findByID(long id);
}
