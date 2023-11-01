package com.example.spring_boot.service;

import org.springframework.http.ResponseEntity;

public interface FilesService {
    ResponseEntity get(String filename);

}
