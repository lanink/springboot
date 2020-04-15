package com.liamxin.learn.web.controller;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * IndexCtl
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/15 08:43
 */

@RestController
@RequestMapping("/index")
public class IndexCtl {


    @GetMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }


    @PostMapping("/post")
    public String post(@RequestBody Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        params.forEach((k, v) -> sb.append(k).append(":").append(v));
        return sb.toString();
    }

    @GetMapping("/call")
    public Callable<String> callable() {
        return () -> "Hello Callable";
    }


    @PostMapping("/file")
    public FileInfo upload(MultipartFile file) throws Exception {
        FileInfo fileInfo = new FileInfo();
        fileInfo.fname = file.getOriginalFilename();
        fileInfo.size = file.getSize();
        return fileInfo;
    }

    @GetMapping("/err/{id:\\d}")
    public String err(@PathVariable Integer id) {
        if (id > 3) {
            throw new RuntimeException("id is not greater than 3");
        }
        return "ok";
    }


    @PostMapping("/user")
    public Map<String, Object> user(@RequestBody Map<String, Object> map) {
        map.put("name", "孙悟空");
        List<String> alias = new ArrayList<>();
        alias.add("齐天大圣");
        alias.add("美猴王");
        map.put("alias", alias);
        return map;

    }


}
