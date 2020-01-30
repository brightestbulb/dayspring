package com.study.dawn.dao;

import com.study.dawn.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BoardDao {

    public void create(HashMap<String, Object> map);

    public HashMap<String, Object> read(int id);

    public void update(HashMap<String, Object> map);

    public void delete(int id);

    public List<HashMap<String,Object>> getAllList();

}
