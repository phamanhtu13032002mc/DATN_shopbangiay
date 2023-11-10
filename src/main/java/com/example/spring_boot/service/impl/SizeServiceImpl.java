package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.entity.SizeEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.SizeRequest;
import com.example.spring_boot.repository.SizeRepository;
import com.example.spring_boot.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeRepository sizeRepository;


    @Override
    public Page<SizeEntity> findAllSize(SizeRequest sizeRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(sizeRequest.getPage()), Math.toIntExact(sizeRequest.getSize()));
        return sizeRepository.findAllProduct(sizeRequest, pageable);
    }

    @Override
    public Object create(SizeRequest sizeRequest) {
        try {
            if (sizeRequest.getName() == null){
                return new DataObj().setEdesc("Name event not null !!!");
            }
            else {
                SizeEntity size = new SizeEntity();
                size.setName(sizeRequest.getName());
                return new DataObj().setEcode("200").setEdesc("Create Complete").setData(sizeRepository.save(size));
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error creating");
        }
    }

    @Override
    public Object detele(SizeRequest sizeRequest) {
        try {
            Optional<SizeEntity> sizeOptional = sizeRepository.findById(sizeRequest.getId());
            if (sizeOptional.isEmpty()) {
                return new DataObj().setEcode("400").setEdesc("ID does not exit !");
            } else {
                SizeEntity size = sizeOptional.get();
                size.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(sizeRepository.save(size));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error delete !!");
        }
    }

    @Override
    public Object update(SizeRequest sizeRequest) {
        try {
            SizeEntity size = sizeRepository.findById(sizeRequest.getId()).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id does not exist !!");
            });
            size.setName(sizeRequest.getName());
            return new DataObj().setEcode("200").setEdesc("update complete").setData(sizeRepository.save(size));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error updating properties");
        }
    }

    @Override
    public Object findByNameLike(SizeRequest sizeRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(sizeRequest.getPage()), Math.toIntExact(sizeRequest.getSize()));
        Page<SizeEntity> sizeEntities = sizeRepository.findByNameLike(sizeRequest.getName(), pageable);

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData(sizeEntities.getContent());

        return dataObj;
    }
}
