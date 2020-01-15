package com.study.dawn.controller;

import com.study.dawn.common.ErrorCode;
import com.study.dawn.common.EventLog;
import com.study.dawn.exception.NotFoundException;
import com.study.dawn.service.BoardService;
import com.study.dawn.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/board")
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    @EventLog(logCode="CREATE")
    public ResponseEntity insert(@RequestBody BoardVO boardVO) throws Exception{

        try {
            String title = boardVO.getTitle();
            String content = boardVO.getContent();
            String writer = boardVO.getWriter();

            if(StringUtils.isEmpty(title) || StringUtils.isEmpty(content) || StringUtils.isEmpty(writer)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title", title);
            map.put("content", content);
            map.put("writer", writer);

            boardService.regist(map);

            return new ResponseEntity<>(HttpStatus.OK);

        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @GetMapping("/{bno}")
    @EventLog(logCode="READ", key = "bno")
    public ResponseEntity read(@PathVariable("bno") int bno) throws Exception{

        try {
            if(StringUtils.isEmpty(bno)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }

            HashMap<String, Object> map  = boardService.read(bno);

            if(StringUtils.isEmpty(map)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "No data");
            }
            return new ResponseEntity<>(map, HttpStatus.OK);

        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @PutMapping("/{bno}")
    @EventLog(logCode="UPDATE", key = "bno")
    public ResponseEntity update(@PathVariable int bno, @RequestBody BoardVO boardVO) throws Exception{

        try {
            String title = boardVO.getTitle();
            String content = boardVO.getContent();

            if(StringUtils.isEmpty(title) || StringUtils.isEmpty(content)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("bno", bno);
            map.put("title", title);
            map.put("content", content);
            boardService.modify(map);

            return new ResponseEntity<>(HttpStatus.OK);

        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{bno}")
    @EventLog(logCode="DELETE", key = "bno")
    public ResponseEntity delete(@PathVariable("bno") int bno) throws Exception{

        try {
            if(StringUtils.isEmpty(bno)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }
            boardService.remove(bno);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
}
