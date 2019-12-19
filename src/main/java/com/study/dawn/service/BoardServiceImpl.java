package com.study.dawn.service;

import com.study.dawn.dao.BoardDao;
import com.study.dawn.vo.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao dao;

    @Override
    public void regist(BoardVO vo){
        dao.create(vo);
    }

    @Override
    public HashMap<String, Object> read(int bno) {
        return dao.readBoard(bno);
    }

    @Override
    public void modify(BoardVO vo){
        dao.update(vo);
    }

    @Override
    public void remove(int bno){
        dao.delete(bno);
    }
}
