package com.liamxin.learn.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * IndexCtlTest
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/15 09:35
 */
@SpringBootTest
public class IndexCtlTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenIndexSuccess() throws Exception {
        mockMvc.perform(get("/index/"))
                .andExpect(status().isOk());
    }


    @Test
    public void whenErrSuccess() throws Exception {
        String params = "{\"id\":1}";
        String result = mockMvc.perform(
                post("/index/user")
                        .content(params)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("孙悟空"))
//                .andDo(System.out::print)
                .andReturn().getResponse().getContentAsString(UTF_8);

        System.out.println(result);

    }


}
