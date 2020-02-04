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
        Assert.assertTrue(boardService.regist(map)>0);

        int new_id = (Integer)map.get("id");

        //READ
        HashMap<String, Object> result = boardService.read(new_id);
        Assert.assertTrue(result.get("title").equals("테스트 글 입니다."));

        //UPDATE
        map.put("id", new_id);
        map.put("done", true);
        Assert.assertTrue(boardService.toggleDone(map)>0);

        result = boardService.read(new_id);
        Assert.assertTrue(result.get("done").equals(true));

        //DELETE
        Assert.assertTrue(boardService.remove(new_id)>0);
    }

    @Test
    public void getAllListTest() throws Exception{

        //when
        List<HashMap<String, Object>> list = boardService.getAllList();

        //then
        Assert.assertTrue(list.size()>0);
        Assert.assertTrue((Long)list.get(0).get("id")==3L);
        Assert.assertTrue(list.get(0).get("title").equals("세번째 글"));
        Assert.assertTrue(list.get(0).get("done").equals(false));
    }

}
