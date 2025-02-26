package com.joy.record.service;

import com.joy.record.model.Joy;

import java.util.HashMap;
import java.util.List;

public interface JoyService {

    public List<Joy> selectJoyList(HashMap<String, Object> param);
    public int insertJoy(HashMap<String, Object> param);
    public int updateJoy(HashMap<String, Object> param);
    public List<Joy> selectJoyCount(HashMap<String, Object> param);
    public List<Joy> selectJoyCountMonth(HashMap<String, Object> param);



}
