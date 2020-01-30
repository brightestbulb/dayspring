package com.study.dawn.dao;

import com.study.dawn.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface BoardDao {

    public void create(HashMap<String, Object> map);

    public HashMap<String, Object> read(int bno);

    public void update(HashMap<String, Object> map);

    public void delete(int bno);

}
