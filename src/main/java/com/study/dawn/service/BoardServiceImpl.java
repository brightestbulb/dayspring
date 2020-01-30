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
    public void regist(HashMap<String, Object> map){
        dao.create(map);
    }

    @Override
    public HashMap<String, Object> read(int id) {
        return dao.read(id);
    }

    @Override
    public void modify(HashMap<String, Object> map){
        dao.update(map);
    }

    @Override
    public void remove(int id){
        dao.delete(id);
    }

    @Override
    public List<HashMap<String, Object>> getAllList(){
        return dao.getAllList();
    }
}
