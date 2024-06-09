package com.joy.record.mapper;

import com.joy.record.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    List<Member> selectMemberList(HashMap<String, Object> param);
    Member selectMemberOne(HashMap<String, Object> param);
    int insertMember(HashMap<String, Object> param);
    int updateMember(HashMap<String, Object> param);
    int deleteMember(HashMap<String, Object> param);

    /** 회원가입 로그인 관련 **/
    //아이디로 회원 데이터 조회
    Member findByUsername(String user_id);
    //회원 pk로 회원정보 조회
    Optional<Member> selectMemberOne(int member_id);


}


