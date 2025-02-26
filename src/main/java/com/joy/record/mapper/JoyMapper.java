package com.joy.record.mapper;

import com.joy.record.model.Joy;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface JoyMapper {

    List<Joy> selectJoyList(HashMap<String, Object> param);
    int insertJoy(HashMap<String, Object> param);
    int updateJoy(HashMap<String, Object> param);
    List<Joy> selectJoyCount(HashMap<String, Object> param);
    List<Joy> selectJoyCountMonth(HashMap<String, Object> param);

}


