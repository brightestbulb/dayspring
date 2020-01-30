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
    public void regist(HashMap<String, Object> map){
        dao.create(map);
    }

    @Override
    public HashMap<String, Object> read(int bno) {
        return dao.read(bno);
    }

    @Override
    public void modify(HashMap<String, Object> map){
        dao.update(map);
    }

    @Override
    public void remove(int bno){
        dao.delete(bno);
    }
}
