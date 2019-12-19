package com.study.dawn.dao;

import com.study.dawn.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface BoardDao {

    public void create(BoardVO vo);

    public HashMap<String, Object> readBoard(int bno);

    public void update(BoardVO vo);

    public void delete(int bno);

}
