package com.example.spring_boot.controller.admin;

import com.example.spring_boot.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/image")
public class UploatImgController {
    @Autowired
    FilesService filesService;
    @Autowired
    public UploatImgController(FilesService filesService) {
        this.filesService = filesService;
    }
    @GetMapping(value = "/get/{fileName}")
    public ResponseEntity get(@PathVariable("fileName") String fileName) {
        return filesService.get(fileName);
    }


    @PostMapping("/upload")
    public ResponseEntity<List<String>> upload(@RequestPart("files") List<MultipartFile> files) {
        List<String> uploadedFiles = files.stream()
                .map(this::uploadFile)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(uploadedFiles);
    }

    private String uploadFile(MultipartFile file) {
        try {
            String fileName = filesService.store(file);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
}

