package com.joy.record.service;

import com.joy.record.model.Member;
import java.util.HashMap;
import java.util.List;

public interface MemberService {

    public List<Member> selectMemberList(HashMap<String, Object> param);
    public Member selectMemberOne(HashMap<String, Object> param);
    public int insertMember(HashMap<String, Object> param);
    public int updateMember(HashMap<String, Object> param);
    public int deleteMember(HashMap<String, Object> param);
    public int countMemberId(HashMap<String, Object> param);

}
