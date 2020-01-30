package com.study.dawn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest() throws Exception{
        mockMvc.perform(get("/v1/board/1")
                .accept(MediaType.APPLICATION_JSON_UTF8).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.writer").value("admin"))
                .andExpect(jsonPath("$.title").value("첫번째 글"))
                .andExpect(jsonPath("$.content").value("첫번째 내용"));
    }

    @Test
    public void postTest() throws Exception{
        mockMvc.perform(post("/v1/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"MockMvc test title\",\"content\":\"MockMvc test content\",\"writer\":\"admin\", \"reg_date\":\"2020-01-03\"}"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()); // test 응답 결과에 대한 모든 내용 출력
    }

    @Test
    public void putTest() throws Exception{
        mockMvc.perform(put("/v1/board/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Update MockMvc test title\",\"content\":\"Update MockMvc test content\",\"writer\":\"admin\", \"reg_date\":\"2020-01-06\"}"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()); // test 응답 결과에 대한 모든 내용 출력
    }

    @Test
    public void deleteTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/board/6"))
                .andExpect(status().isOk());
    }
}


