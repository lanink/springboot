package com.liamxin.learn.jpa.repository;

import com.liamxin.learn.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    Optional<User> findByAge(String age);

    List<User> findByAgeBetween(String age, String age2);

    Page<User> findByName(String name, Pageable pageable);

    Page<User> findAllByNameAndAgeBetween(String name, String age, String age2, Pageable pageable);

    @Query(value = "FROM User WHERE id = ?1")
    User customFind(Integer id);

    @Query(value = "SELECT * FROM user WHERE name = ?1", nativeQuery = true)
    Optional<User> customFindByName(String name);

}
