package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.ImageRequest;
import com.example.spring_boot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/image-manager")
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping(value = "/find-all")
    public ResponseEntity<Page<ImageEntity>> getImageList(@RequestBody ImageRequest pageableImageRequest) {
        PageRequest pageRequest = PageRequest.of(pageableImageRequest.getPage(), pageableImageRequest.getSize());
        Page<ImageEntity> billList = imageService.findAll(pageableImageRequest.getImageRequest(), pageRequest);
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Long id) {
        Optional<ImageEntity> imageRequest = imageService.findByID(id);

        if (imageRequest.isPresent()) {
            return new ResponseEntity(imageRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
