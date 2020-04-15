package com.liamxin.learn.jpa.repository;

import com.liamxin.learn.jpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Integer countByUserId(Integer userId);
}
