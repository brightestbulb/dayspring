package com.study.dawn.controller;

import com.study.dawn.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class BoardController {

    @RequestMapping("/test")
    private String jspTest() throws Exception {

        return "test";
    }
}
