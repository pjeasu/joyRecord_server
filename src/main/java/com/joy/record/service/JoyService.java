package com.joy.record.service;

import com.joy.record.model.Joy;

import java.util.HashMap;
import java.util.List;

public interface JoyService {

    public List<Joy> selectJoyList(HashMap<String, Object> param);
    public int insertJoy(HashMap<String, Object> param);
    public int updateJoy(HashMap<String, Object> param);
    public int deleteJoy(HashMap<String, Object> param);


}
