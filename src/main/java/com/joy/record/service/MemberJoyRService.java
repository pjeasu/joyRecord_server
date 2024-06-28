package com.joy.record.service;

import com.joy.record.model.Joy;

import java.util.HashMap;
import java.util.List;

public interface MemberJoyRService {

    public List<Joy> selectMemberJoyRList(HashMap<String, Object> param);
    public int insertMemberJoyR(HashMap<String, Object> param);
    public int updateMemberJoyR(HashMap<String, Object> param);
    public int upsertMemberJoyR(List<HashMap<String, Object>> param);
    public int deleteMemberJoyR(HashMap<String, Object> param);


}
