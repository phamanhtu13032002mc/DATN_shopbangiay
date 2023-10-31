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
    public ResponseEntity<DataObj> createEvent(@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(new DataObj(eventService.create(eventRequest),"thêm thành công ",true));
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<DataObj> deteleEvent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new DataObj(eventService.detele(id), "Xóa thành công", true));
    }
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<DataObj> updateEvent(@PathVariable("id") Long id ,@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(new DataObj(eventService.update(id,eventRequest),"thêm thành công ",true));
    }






}
