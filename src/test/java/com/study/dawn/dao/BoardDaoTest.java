package com.study.dawn.dao;

import com.study.dawn.service.BoardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardDaoTest {

    @Autowired
    BoardService boardService;

    @Test
    public void getAllList() throws Exception {

        List<HashMap<String,Object>> list = boardService.getAllList();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void crudTest() throws Exception {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "테스트 글 입니다.");

        //INSERT
        boardService.regist(map);
        Assert.assertTrue(boardService.regist(map)>0);

        int new_id = (Integer)map.get("id");

        //READ
        HashMap<String, Object> map2 = boardService.read(new_id);
        Assert.assertTrue(map2.get("title").equals("테스트 글 입니다."));

        //UPDATE
        map.put("id", new_id);
        map.put("title", "수정된 글 입니다.");
        Assert.assertTrue(boardService.modify(map)>0);

        map2 = boardService.read(new_id);
        Assert.assertTrue(map2.get("title").equals("수정된 글 입니다."));

        //DELETE
        Assert.assertTrue(boardService.remove(new_id)>0);
    }

    @Test
    public void insertUpdateDeleteTest() throws Exception{

    }

}
