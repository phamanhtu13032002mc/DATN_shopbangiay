package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.repository.EventRepository;
import com.example.spring_boot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public DataObj create(EventRequest eventRequest) {
     try {
        if (eventRequest.getName() == null){
           return new DataObj().setEdesc("Name event not null !!!");
        }
         if (eventRequest.getStartDay() == null){
             return new DataObj().setEdesc("Start day not null !!!");
         }
         if (eventRequest.getEndDay() == null){
             return new DataObj().setEdesc("End day not null !!!");
         }
         if (eventRequest.getStartDay().isAfter(eventRequest.getEndDay()) || eventRequest.getStartDay().isEqual(eventRequest.getEndDay())) {
             return new DataObj().setEdesc("The end day cannot be less than the start day !!!");
         } else {
            EventEntity event = new EventEntity();
            event.setName(eventRequest.getName());
            event.setEndDay(eventRequest.getEndDay());
            event.setStartDay(eventRequest.getStartDay());
            return new DataObj().setEcode("200").setEdesc("Create Complete").setData(eventRepossitory.save(event));

        }
     }catch (Exception e){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xử lý ngày tháng");
     }
    }

    @Override
    public DataObj detele(EventRequest eventRequest) {
        try {
            Optional<EventEntity> eventOptional = eventRepossitory.findById(eventRequest.getId_event());
            if (eventOptional.isEmpty()) {
                return new DataObj().setEcode("400").setEdesc("ID does not exit !");
            } else {
                EventEntity event = eventOptional.get();
                event.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(eventRepossitory.save(event));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }

    @Override
    public DataObj update( EventRequest eventRequest) {
        try {
            Optional<EventEntity> optionalEvent = eventRepossitory.findById(eventRequest.getId_event());
            if (optionalEvent.isPresent()) {
                EventEntity event = optionalEvent.get();
                event.setName(eventRequest.getName());
                event.setStartDay(eventRequest.getStartDay());
                event.setEndDay(eventRequest.getEndDay());
                return new DataObj().setEcode("200").setEdesc("Success ").setData(eventRepossitory.save(event));
            } else {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi update");
        }

    }
}

