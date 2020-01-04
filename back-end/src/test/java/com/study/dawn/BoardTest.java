package com.study.dawn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/v1/board/1")
                .accept(MediaType.APPLICATION_JSON_UTF8).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(jsonPath("$.bno").value("1"))
                .andExpect(jsonPath("$.writer").value("admin"))
                .andExpect(jsonPath("$.title").value("첫번째 글 입니다."))
                .andExpect(jsonPath("$.content").value("첫번째 테스트 게시글 입니다."));
    }

}
