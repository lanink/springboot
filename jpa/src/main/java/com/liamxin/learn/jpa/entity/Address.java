package com.liamxin.learn.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Address
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/15 10:30
 */
@Data
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String street;

    private String detail;
}
