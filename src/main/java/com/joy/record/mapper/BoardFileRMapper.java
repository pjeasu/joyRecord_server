package com.joy.record.mapper;

import com.joy.record.model.Board;
import com.joy.record.model.BoardFileR;
import com.joy.record.model.Joy;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardFileRMapper {

    HashMap<String, Object> insertBoardFileR(HashMap<String, Object> param);
    List<BoardFileR>  selectBoardFile(HashMap<String, Object> param);

}


