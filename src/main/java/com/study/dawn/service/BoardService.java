package com.study.dawn.service;

import com.study.dawn.vo.BoardVO;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

    public void regist(HashMap<String, Object> map) throws Exception;

    public HashMap<String, Object> read(int id) throws Exception;

    public void modify(HashMap<String, Object> map) throws Exception;

    public void remove(int id) throws Exception;

    public List<HashMap<String,Object>> getAllList() throws Exception;
}
