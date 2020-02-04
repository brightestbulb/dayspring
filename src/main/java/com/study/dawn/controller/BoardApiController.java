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
import java.util.List;

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
            String writer = boardVO.getWriter();

            if(StringUtils.isEmpty(title) || StringUtils.isEmpty(writer)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title", title);
            map.put("writer", writer);

            boardService.regist(map);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    @EventLog(logCode="READ", key = "id")
    public ResponseEntity read(@PathVariable("id") int id) throws Exception{

        try {
            if(StringUtils.isEmpty(id)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }

            HashMap<String, Object> map  = boardService.read(id);

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

    @PutMapping("/{id}")
    @EventLog(logCode="UPDATE", key = "id")
    public ResponseEntity update(@PathVariable int id, @RequestBody BoardVO boardVO) throws Exception{

        try {
            Boolean done = boardVO.isDone();
            if(StringUtils.isEmpty(done)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", id);
            map.put("done", done);
            boardService.toggleDone(map);

            return new ResponseEntity<>(HttpStatus.OK);

        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    @EventLog(logCode="DELETE", key = "id")
    public ResponseEntity delete(@PathVariable("id") int id) throws Exception{

        try {
            if(StringUtils.isEmpty(id)){
                throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, "Please enter a required value.");
            }
            boardService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NotFoundException ne){
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR, ne.getMessage(), ne);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @GetMapping("/")
    @EventLog(logCode="READ")
    public ResponseEntity getAllList() throws Exception{
        try{
            List<HashMap<String,Object>> list = boardService.getAllList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
}
