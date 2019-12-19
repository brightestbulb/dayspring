package com.study.dawn.service;

import com.study.dawn.vo.BoardVO;

import java.util.HashMap;

public interface BoardService {

    public void regist(BoardVO vo) throws Exception;

    public HashMap<String, Object> read(int bno) throws Exception;

    public void modify(BoardVO vo) throws Exception;

    public void remove(int bno) throws Exception;
}
