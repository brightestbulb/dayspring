package com.study.dawn.service;

import com.study.dawn.vo.BoardVO;

import java.util.HashMap;

public interface BoardService {

    public void regist(HashMap<String, Object> map) throws Exception;

    public HashMap<String, Object> read(int bno) throws Exception;

    public void modify(HashMap<String, Object> map) throws Exception;

    public void remove(int bno) throws Exception;
}
