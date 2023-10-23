package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.security.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/event-manager")
public class EventController {
    @Autowired
    EventService eventService;
    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getCategoryList() {
        return new  ResponseEntity(eventService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<?> SaveEvent(@RequestBody EventEntity eventEntity) {
        return new  ResponseEntity(eventService.save(eventEntity), HttpStatus.OK);
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateEvent(@RequestBody EventEntity eventEntity) {
        return new  ResponseEntity(eventService.save(eventEntity), HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") long id) {
        eventService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }
    @GetMapping(value = "/find-by-id/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") long id) {
        return new  ResponseEntity(eventService.findByID(id), HttpStatus.OK);
    }
}
