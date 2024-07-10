package com.joy.record.service.impl;

import com.joy.record.mapper.BoardMapper;
import com.joy.record.model.Board;
import com.joy.record.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    @Transactional
    public List<Board> selectBoardList(HashMap<String, Object> param) {
        logger.info("=======================selectBoardList");
        logger.info(String.valueOf(param));

        return boardMapper.selectBoardList(param);
    }

    @Override
    public Board selectBoardOne(HashMap<String, Object> param) {
        return boardMapper.selectBoardOne(param);
    }

    @Override
    public HashMap<String, Object> insertBoard(HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("success", boardMapper.insertBoard(param));
        result.put("board_id", param.get("board_id")); // 게시글 파일 첨부를 위해 board_id 프론트로 보내기
        return result;
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
