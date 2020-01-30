package com.study.dawn;

import com.study.dawn.service.BoardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardDaoTest {

    @Autowired
    BoardService boardService;

    @Test
    public void readTest() throws Exception {
        //when
        List<HashMap<String,Object>> list = boardService.getAllList();
        //then
        Assert.assertTrue(list.size()>0);
    }
}
