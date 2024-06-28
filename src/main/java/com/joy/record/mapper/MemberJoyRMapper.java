package com.joy.record.mapper;

import com.joy.record.model.Joy;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberJoyRMapper {

    List<Joy> selectMemberJoyRList(HashMap<String, Object> param);
    int insertMemberJoyR(HashMap<String, Object> param);
    int updateMemberJoyR(HashMap<String, Object> param);
    int upsertMemberJoyR(HashMap<String, Object> param);
    int deleteMemberJoyR(HashMap<String, Object> param);

}


