package com.study.dawn.controller;

import com.study.dawn.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/test")
    private String jspTest() throws Exception {

        int id = 1;
        System.out.println("------------------------------------------");
        System.out.println( boardService.read(id));
        System.out.println("------------------------------------------");

        return "test";
    }
}
