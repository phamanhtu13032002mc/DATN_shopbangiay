package com.example.spring_boot.repository;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.request.EventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity,Long>{
    @Query(value = "SELECT * FROM event WHERE is_delete = 0 ORDER BY id_event DESC",nativeQuery = true)
    Page<EventEntity> findAllEvent(EventRequest eventRequest, Pageable pageable);
    @Query("SELECT E FROM EventEntity E WHERE :name IS NULL OR E.name LIKE %:name%")
    Page<EventEntity> findByNameLike(@Param("name") String name,Pageable pageable);

    boolean existsByName(String name);
}
