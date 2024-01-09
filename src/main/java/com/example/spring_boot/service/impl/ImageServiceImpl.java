package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.ImageEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.FindImageByIdPrdRequest;
import com.example.spring_boot.payload.request.ImageRequest;
import com.example.spring_boot.repository.ImageRepository;
import com.example.spring_boot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public Optional<ImageEntity> findByID(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Page<ImageEntity> findAllImage(ImageRequest imageRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(imageRequest.getPage()), Math.toIntExact(imageRequest.getSize()));
        return imageRepository.findAllImage(imageRequest, pageable);
    }

    @Override
    public Object findImageByIdProduct(FindImageByIdPrdRequest findImageByIdPrdRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(findImageByIdPrdRequest.getPage()), Math.toIntExact(findImageByIdPrdRequest.getSize()));
        Page<ImageEntity> imageEntities = imageRepository.findByNameLike(findImageByIdPrdRequest.getIdProduct(), pageable);

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData(imageEntities.getContent());

        return dataObj;
    }
    @Transactional
    public Object deleteImagesByProductId(Long idProduct) {
        // Lấy danh sách ảnh dựa trên ID sản phẩm
        List<ImageEntity> imageEntities = imageRepository.findByProductId(idProduct);

        // Xóa từng ảnh và thư mục liên quan
        for (ImageEntity imageEntity : imageEntities) {
            deleteImageAndDirectory(imageEntity);
        }

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData("Images and directories deleted successfully.");

        return dataObj;
    }

    private void deleteImageAndDirectory(ImageEntity imageEntity) {
        // Xóa ảnh từ cơ sở dữ liệu
        imageRepository.delete(imageEntity);

        // Xây dựng đường dẫn đến thư mục ảnh
        Path imagePath = Paths.get("uploads", imageEntity.getName());

        try {
            // Xóa ảnh từ thư mục
            java.nio.file.Files.delete(imagePath);

            // Xóa thư mục nếu nó trống rỗng
            Path parentDirectory = imagePath.getParent();
            if (parentDirectory != null && java.nio.file.Files.list(parentDirectory).count() == 0) {
                java.nio.file.Files.delete(parentDirectory);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete image and directory: " + imageEntity.getName(), e);
        }
    }


}
