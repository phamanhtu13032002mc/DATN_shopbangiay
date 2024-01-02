package com.example.spring_boot.repository;

import java.util.Optional;

import com.example.spring_boot.entity.ERole;
import com.example.spring_boot.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);

    @Query(value = "SELECT * FROM roles WHERE id = ? ",nativeQuery = true)
    RoleEntity findByIdRole(Long id);
}
