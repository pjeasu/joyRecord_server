package com.joy.record.mapper;

import com.joy.record.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> selectBoardList(HashMap<String, Object> param);
    List<Board> selectBoardCalList(HashMap<String, Object> param);
    Board selectBoardOne(HashMap<String, Object> param);
    int insertBoard(HashMap<String, Object> param);
    int updateBoard(HashMap<String, Object> param);
    int deleteBoard(HashMap<String, Object> param);

}


