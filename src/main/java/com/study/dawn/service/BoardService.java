package com.study.dawn.service;

import com.study.dawn.vo.BoardVO;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

    public int regist(HashMap<String, Object> map) throws Exception;

    public HashMap<String, Object> read(int id) throws Exception;

    public int toggleDone(HashMap<String, Object> map) throws Exception;

    public int remove(int id) throws Exception;

    public List<HashMap<String,Object>> getAllList() throws Exception;
}
