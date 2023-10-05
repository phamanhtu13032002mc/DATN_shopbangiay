package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Productdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface productDetailRepository extends JpaRepository<Productdetail,Long> {
    @Query(value = "SELECT * FROM product_detail WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<Productdetail> findAllByIsDeleteFase();
    @Query(value ="SELECT * FROM product_detail WHERE idsize = ? AND idproperty = ? AND idProduct = ?",nativeQuery = true)
    Optional<Productdetail> CheckPrd(Long idsize, long idproperty, Long idProduct);







}
