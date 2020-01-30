package com.study.dawn.service;

import com.study.dawn.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao dao;

    @Override
    public int regist(HashMap<String, Object> map){
        return dao.create(map);
    }

    @Override
    public HashMap<String, Object> read(int id) {
        return dao.read(id);
    }

    @Override
    public int modify(HashMap<String, Object> map){
        return dao.update(map);
    }

    @Override
    public int remove(int id){
        return dao.delete(id);
    }

    @Override
    public List<HashMap<String, Object>> getAllList(){
        return dao.getAllList();
    }
}
