package com.joy.record.service.impl;

import com.joy.record.mapper.JoyMapper;
import com.joy.record.model.Joy;
import com.joy.record.service.JoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class JoyServiceImpl implements JoyService {

    @Autowired
    JoyMapper joyMapper;


    @Override
    public List<Joy> selectJoyList(HashMap<String, Object> param) {
        return joyMapper.selectJoyList(param);
    }

    @Override
    public int insertJoy(HashMap<String, Object> param) {
        return joyMapper.insertJoy(param);
    }
    @Override
    public int updateJoy(HashMap<String, Object> param) {
        return joyMapper.updateJoy(param);
    }

}
