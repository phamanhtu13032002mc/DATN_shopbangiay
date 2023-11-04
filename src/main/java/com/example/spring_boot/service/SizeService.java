package com.example.spring_boot.service;

import com.example.spring_boot.entity.SizeEntity;
import com.example.spring_boot.payload.request.SizeRequest;
import com.example.spring_boot.payload.response.SizeResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SizeService {


    Page<SizeEntity> findAllSize(SizeRequest sizeRequest);

    Object create(SizeRequest sizeRequest);

    Object detele(SizeRequest sizeRequest);

    Object update(SizeRequest sizeRequest);
}
