package com.example.spring_boot.controller.admin;

import com.example.spring_boot.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/image")
public class UploatImgController {
    @Autowired
    FilesService filesService;
    @GetMapping(value = "/get/{fileName}")
    public ResponseEntity get(@PathVariable("fileName") String fileName) {
        return filesService.get(fileName);
    }
}
