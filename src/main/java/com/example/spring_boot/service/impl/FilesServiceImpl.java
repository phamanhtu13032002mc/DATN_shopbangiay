package com.example.spring_boot.service.impl;

import com.example.spring_boot.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilesServiceImpl implements FilesService {
    private final Path root = Paths.get("saveImg");

    @Override
    public ResponseEntity get(String filename) {
        Path path = root.resolve(filename).normalize();
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                MediaType mediaType = MediaTypeFactory.getMediaType(filename).get();
                return ResponseEntity
                        .ok()
                        .contentType(mediaType)
                        .body(resource);
            }

        } catch (MalformedURLException e) {
            System.out.println(e);

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loi roi");
    }
}
