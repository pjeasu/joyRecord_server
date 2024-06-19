package com.joy.record.service.impl;

import com.joy.record.mapper.MemberMapper;
import com.joy.record.model.Member;

import com.joy.record.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;


    @Override
    public List<Member> selectMemberList(HashMap<String, Object> param) {
        return memberMapper.selectMemberList(param);
    }

    @Override
    public Member selectMemberOne(HashMap<String, Object> param) {
        return memberMapper.selectMemberOne(param);
    }

    @Override
    public int insertMember(HashMap<String, Object> param) {
        return memberMapper.insertMember(param);
    }

    @Override
    public int updateMember(HashMap<String, Object> param) {
        return memberMapper.updateMember(param);
    }

    @Override
    public int deleteMember(HashMap<String, Object> param) {
        return memberMapper.deleteMember(param);
    }

    @Override
    public int countMemberId(HashMap<String, Object> param){
        return memberMapper.countMemberId(param);
    }
}
