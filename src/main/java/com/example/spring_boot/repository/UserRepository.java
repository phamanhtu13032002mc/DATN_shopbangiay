package com.example.spring_boot.repository;

import java.util.List;
import java.util.Optional;

import com.example.spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users where is_delete = 0 order by id desc ",nativeQuery = true)
    List<User> findAllByDeleteFalse();

    @Query(value = "select * from users where username LIKE %:username%  order by id desc ",nativeQuery = true)
    List<User> findUserByLike(@Param("username") String username);
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByPhone(String phone);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
