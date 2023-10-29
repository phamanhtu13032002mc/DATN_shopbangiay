package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/event-manager")
public class EventController {
    @Autowired
    EventService eventService;
    @PostMapping(value = "/find-all")
    public ResponseEntity<Page<EventEntity>> getImageList(
            @RequestBody EventRequest pageableEventRequest) {
        PageRequest pageRequest = PageRequest.of(pageableEventRequest.getPage(), pageableEventRequest.getSize());
        Page<EventEntity> eventList = eventService.findAll(pageRequest);
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        Optional<EventEntity> eventRequest = eventService.findByID(id);

        if (eventRequest.isPresent()) {
            return new ResponseEntity(eventRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }



}
