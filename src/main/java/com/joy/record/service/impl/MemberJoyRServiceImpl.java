package com.joy.record.service.impl;

import com.joy.record.mapper.MemberJoyRMapper;
import com.joy.record.model.Joy;
import com.joy.record.service.MemberJoyRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberJoyRServiceImpl implements MemberJoyRService {

    @Autowired
    MemberJoyRMapper memberJoyRMapper;


    @Override
    public List<Joy> selectMemberJoyRList(HashMap<String, Object> param) {
        return memberJoyRMapper.selectMemberJoyRList(param);
    }

    @Override
    public int insertMemberJoyR(HashMap<String, Object> param) {
        return memberJoyRMapper.insertMemberJoyR(param);
    }

    @Override
    public int updateMemberJoyR(HashMap<String, Object> param) {
        return memberJoyRMapper.updateMemberJoyR(param);
    }

    @Override
    public int deleteMemberJoyR(HashMap<String, Object> param) {
        return memberJoyRMapper.deleteMemberJoyR(param);
    }


}
