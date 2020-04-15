package com.liamxin.learn.jpa.controller;

import com.liamxin.learn.jpa.entity.Address;
import com.liamxin.learn.jpa.entity.User;
import com.liamxin.learn.jpa.repository.AddressRepository;
import com.liamxin.learn.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * IndexCtl
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/15 10:39
 */
@RestController
public class IndexCtl {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    @Autowired
    public IndexCtl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }


    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/address")
    public Page<Address> getAddressByPage(){
        return addressRepository.findAll(PageRequest.of(0, 10));
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userRepository.save(user);
//        User user1 = userRepository.saveAndFlush(user);
//        List<User> users = new ArrayList<>();
//        userRepository.saveAll(users);
    }

    @GetMapping("/u")
    public User getUser(){
        User user = userRepository.customFind(1);
        Integer integer = addressRepository.countByUserId(user.getId());
        System.out.printf("%s 有 %d 个地址", user.getId(), integer);

        Optional<User> optional = userRepository.customFindByName("猪八戒");
        optional.ifPresent(System.out::println);


        return user;
    }


}
