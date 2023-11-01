package com.example.spring_boot.controller.admin;


import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.DataObj;

import com.example.spring_boot.payload.request.EventRequest;

import com.example.spring_boot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/event-manager")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getEventList(
            @RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(eventService.findAllEvent(eventRequest));
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
    @PostMapping(value = "/create")
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(eventService.create(eventRequest));
    }
    @PostMapping ("/delete")
    public ResponseEntity<?> deteleEvent(@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(eventService.detele(eventRequest));
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateEvent(@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(eventService.update(eventRequest));
    }






}
