package com.joy.record.service;

import com.joy.record.model.BoardFileR;
import com.joy.record.model.Joy;

import java.util.HashMap;
import java.util.List;

public interface BoardFileRService {

    List<BoardFileR>  selectBoardFile(HashMap<String, Object> param);

}
