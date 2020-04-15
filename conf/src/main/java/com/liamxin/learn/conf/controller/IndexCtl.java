package com.liamxin.learn.conf.controller;

import com.liamxin.learn.conf.conf.CustomConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexCtl
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020-04-14 13:38
 */
@RestController
public class IndexCtl {

    private final CustomConf customConf;

    @Value("${pig.name}")
    private String name;

    @Value("#{5*5}")
    private String age;


    @Autowired
    public IndexCtl(CustomConf customConf) {
        this.customConf = customConf;
    }

    @GetMapping("/")
    public String index() {

        return customConf.toString() + name + age;
    }

}
