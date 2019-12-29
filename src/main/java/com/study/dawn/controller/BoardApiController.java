package com.study.dawn.controller;

import com.study.dawn.service.BoardService;
import com.study.dawn.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/board")
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping
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

    @GetMapping("/{bno}")
    public HashMap<String, Object> readPost(@PathVariable("bno") int bno) throws Exception{
        HashMap<String, Object> map = boardService.read(bno);
        return map;
    }

    @PutMapping("/{bno}")
    public void updatePost(@PathVariable int bno, @RequestBody BoardVO boardVO) throws Exception{

        String title = boardVO.getTitle();
        String content = boardVO.getContent();

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("bno", bno);
        map.put("title", title);
        map.put("content", content);

        boardService.modify(map);
    }

    @DeleteMapping("/{bno}")
    public void deletePost(@PathVariable("bno") int bno) throws Exception{
        boardService.remove(bno);
    }
}
