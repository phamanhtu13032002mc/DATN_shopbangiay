package com.example.spring_boot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.List;

public interface FilesService {
    ResponseEntity get(String filename);
    String store(MultipartFile file) throws IOException;

    Resource loadAsResource(String filename);

    List<String> listAll();

}
