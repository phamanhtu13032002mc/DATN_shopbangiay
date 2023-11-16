package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.payload.request.CustomerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    @Query(value = "SELECT * FROM customer WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<CustomerEntity> findAllCustomer(CustomerRequest customerRequest, Pageable pageable);
    @Query("SELECT E FROM CustomerEntity E WHERE E.fullName LIKE %:name%")
    Page<CustomerEntity> findByNameLike(String name,Pageable pageable);
    @Query(value = "SELECT * FROM customer  cs WHERE cs.id_user = ?",nativeQuery = true)
    CustomerEntity findByIdUser(Long id);
}
