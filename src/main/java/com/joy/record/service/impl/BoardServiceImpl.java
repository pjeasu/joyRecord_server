package com.joy.record.service.impl;

import com.joy.record.mapper.BoardMapper;
import com.joy.record.model.Board;
import com.joy.record.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;


    @Override
    public List<Board> selectBoardList(HashMap<String, Object> param) {
        return boardMapper.selectBoardList(param);
    }

    @Override
    public Board selectBoardOne(HashMap<String, Object> param) {
        return boardMapper.selectBoardOne(param);
    }

    @Override
    public int insertBoard(HashMap<String, Object> param) {
        return boardMapper.insertBoard(param);
    }
    @Override
    public int updateBoard(HashMap<String, Object> param) {
        return boardMapper.updateBoard(param);
    }

    @Override
    public int deleteBoard(HashMap<String, Object> param) {
        return boardMapper.deleteBoard(param);
    }



}
