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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public String store(MultipartFile file) throws IOException {
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        Path filePath = root.resolve(fileName);
        file.transferTo(filePath);
        return fileName;
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL", e);
        }
    }

    @Override
    public List<String> listAll() {
        try {
            return java.nio.file.Files.walk(root, 1)
                    .filter(path -> !path.equals(root))
                    .map(root::relativize)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to list files", e);
        }
    }

    private String generateUniqueFileName(String originalFileName) {
        // Viết mã để tạo tên file duy nhất tại đây (ví dụ: thêm timestamp)
        return originalFileName;
    }
}
