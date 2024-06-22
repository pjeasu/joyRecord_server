package com.joy.record.service.impl;

import com.joy.record.mapper.BoardFileRMapper;
import com.joy.record.mapper.BoardMapper;
import com.joy.record.model.Board;
import com.joy.record.model.BoardFileR;
import com.joy.record.service.BoardFileRService;
import com.joy.record.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardFileRServiceImpl implements BoardFileRService {

    @Autowired
    BoardFileRMapper boardFileRMapper;


    @Override
    public List<BoardFileR> selectBoardFile(HashMap<String, Object> param) {
        return boardFileRMapper.selectBoardFile(param);
    }




}
