package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.repository.EventRepository;
import com.example.spring_boot.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.events.Event;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepossitory;
    @Override
    public Optional<EventEntity> findByID(long id) {
        return eventRepossitory.findById(id);
    }

    @Override
    public Page<EventEntity> findAllEvent(EventRequest eventRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(eventRequest.getPage()), Math.toIntExact(eventRequest.getSize()));
        return eventRepossitory.findAllEvent(eventRequest, pageable);
    }

    @Override
    public EventEntity create(EventRequest eventRequest) {
     try {
         EventEntity event = new EventEntity();
         event.setName(eventRequest.getName());
         event.setEndDay(eventRequest.getEndDay());
         event.setStartDay(eventRequest.getStartDay());
         return eventRepossitory.save(event);
     }catch (Exception e){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xử lý ngày tháng");
     }
    }

    @Override
    public EventEntity detele(Long id) {
       try {
           EventEntity event = eventRepossitory.findById(id).orElseThrow(() -> {
               throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không tìm thấy sự kiện");
           });
           event.setIsDelete(true);
           return eventRepossitory.save(event);
       }catch (Exception e){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
       }
    }

    @Override
    public EventEntity update(Long id, EventRequest eventRequest) {
        EventEntity event = eventRepossitory.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không tìm thấy sự kiện");
        });
        event.setName(eventRequest.getName());
        event.setName(eventRequest.getName());
        event.setEndDay(eventRequest.getEndDay());
        event.setStartDay(eventRequest.getStartDay());
        return eventRepossitory.save(event);
    }

}

