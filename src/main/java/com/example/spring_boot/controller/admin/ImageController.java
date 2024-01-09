package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.request.FindImageByIdPrdRequest;
import com.example.spring_boot.payload.request.ImageRequest;
import com.example.spring_boot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getImageList(
            @RequestBody ImageRequest imageRequest) {
        return ResponseEntity.ok(imageService.findAllImage(imageRequest));
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
        @PostMapping(value = "/find-image-by-id-product")
        public ResponseEntity<?> findImageByIdProduct(
                @RequestBody FindImageByIdPrdRequest findImageByIdPrdRequest) {
            return ResponseEntity.ok(imageService.findImageByIdProduct(findImageByIdPrdRequest));
        }
    @PostMapping("/delete-images-by-product-id")
    public ResponseEntity<Object> deleteImagesByProductId(@RequestBody FindImageByIdPrdRequest findImageByIdPrdRequest) {
        Long idProduct = findImageByIdPrdRequest.getIdProduct();
        Object result = imageService.deleteImagesByProductId(idProduct);
        return ResponseEntity.ok(result);
    }




}
