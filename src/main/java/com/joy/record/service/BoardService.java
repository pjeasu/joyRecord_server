package com.joy.record.service;

import com.joy.record.model.Board;
import com.joy.record.model.Member;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

    public List<Board> selectBoardList(HashMap<String, Object> param);
    public List<Board> selectBoardCalList(HashMap<String, Object> param);
    public Board selectBoardOne(HashMap<String, Object> param);
    public HashMap<String, Object> insertBoard(HashMap<String, Object> param);
    public int updateBoard(HashMap<String, Object> param);
    public int deleteBoard(HashMap<String, Object> param);


}
