package com.study.dawn.controller;

import com.study.dawn.service.BoardService;
import com.study.dawn.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/board")
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(method= RequestMethod.POST)
    public void insertPost(@RequestBody BoardVO boardVO) throws Exception{

        String title = boardVO.getTitle();
        String content = boardVO.getContent();
        String writer = boardVO.getWriter();

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("content", content);
        map.put("writer", writer);

        boardService.regist(map);
    }

    @RequestMapping(value="/{bno}", method= RequestMethod.GET)
    public HashMap<String, Object> readPost(@PathVariable("bno") int bno) throws Exception{
        HashMap<String, Object> map = boardService.read(bno);
        return map;
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void updatePost(@RequestBody BoardVO boardVO) throws Exception{

        int bno = boardVO.getBno();
        String title = boardVO.getTitle();
        String content = boardVO.getContent();

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("bno", bno);
        map.put("title", title);
        map.put("content", content);

        boardService.modify(map);
    }

    @RequestMapping(value="/{bno}", method= RequestMethod.DELETE)
    public void deletePost(@PathVariable("bno") int bno) throws Exception{
        boardService.remove(bno);
    }
}
