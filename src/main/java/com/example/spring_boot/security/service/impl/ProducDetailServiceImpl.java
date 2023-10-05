package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Productdetail;
import com.example.spring_boot.payload.request.CreateProductDetail;
import com.example.spring_boot.repository.productDetailRepository;
import com.example.spring_boot.security.service.ProducDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProducDetailServiceImpl implements ProducDetailService {
    @Autowired
    productDetailRepository productDetailRepository;
    @Override
    public List<Productdetail> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public List<Productdetail> findAllByIsDeleteFalse() {
        return productDetailRepository.findAllByIsDeleteFase();
    }



    @Override
    public List<Productdetail> create(CreateProductDetail createProductDetail) {
        List<Productdetail> Productdetails = new ArrayList<>();
        createProductDetail.getPropertyrequest().forEach(property -> {
            Productdetail productdetail = new Productdetail();
            Optional<Productdetail> qty = productDetailRepository.CheckPrd(createProductDetail.getIdsize(), property.getIdproperty(), createProductDetail.getIdpoduct());
            if (qty.isPresent()) {
                productdetail = qty.get();
            } else {
                productdetail.setIdProduct(createProductDetail.getIdpoduct());
                productdetail.setIdsize(createProductDetail.getIdsize());
                productdetail.setIdproperty(property.getIdproperty());
            }
            productdetail.setIsDelete(false);
            productdetail.setQuantity(property.getQuantity());

            Productdetails.add(productdetail);

        });
        return productDetailRepository.saveAll(Productdetails);
    }

    @Override
    public void delete(Long id) {
     Productdetail productdetail = productDetailRepository.findById(id).get();
     productdetail.setIsDelete(true);
     productDetailRepository.save(productdetail);
    }
}
