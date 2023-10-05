package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Event;
import com.example.spring_boot.entity.Voucher;
import com.example.spring_boot.security.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/EventManager")
public class EventController {
    @Autowired
    EventService eventService;
    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getCategoryList() {
        return new  ResponseEntity(eventService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @PostMapping(value = "EventSave")
    public ResponseEntity<?> SaveEvent(@RequestBody Event event) {
        return new  ResponseEntity(eventService.save(event), HttpStatus.OK);
    }
    @PostMapping(value = "EventUpdate")
    public ResponseEntity<?> UpdateEvent(@RequestBody Event event) {
        return new  ResponseEntity(eventService.save(event), HttpStatus.OK);
    }
    @GetMapping(value = "EventDelete/{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable("id") long id) {
        eventService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }
    @GetMapping(value = "FindEventById/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") long id) {

        return new  ResponseEntity(eventService.findByID(id), HttpStatus.OK);
    }
}
