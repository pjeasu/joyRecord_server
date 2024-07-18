package com.joy.record.controller;

import com.joy.record.model.Member;
import com.joy.record.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder pwEncoder;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/selectMemberList")
    public List<Member> selectMemberList(@RequestParam HashMap<String, Object> param) {
        return memberService.selectMemberList(param);
    }

    @GetMapping("/selectMemberOne")
    public Member selectMemberOne(@RequestParam HashMap<String, Object> param) {
        return memberService.selectMemberOne(param);
    }

    @PostMapping("/insertMember")
    public HashMap<String, Object> insertMember(@RequestParam HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", memberService.insertMember(param));
        return result;
    }

    @PutMapping("/updateMember")
    public HashMap<String, Object> updateMember(@RequestBody HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", memberService.updateMember(param));
        return result;
    }

    @PutMapping("/deleteMember")
    public HashMap<String, Object> deleteMember(@RequestBody HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", memberService.deleteMember(param));
        return result;
    }

    //회원가입
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public HashMap<String, Object> signUpMember(@RequestParam HashMap<String, Object> param) throws Exception {

        HashMap<String, Object> result = new HashMap<String, Object>();
        logger.info("join 진입");

        String rawPw = ""; //사용자가 입력한 값
        String encodePw = ""; // 암호화된 값

        //아이디 중복조회
        int cnt = memberService.countMemberId(param);
        if (0 < cnt) {
            logger.info("아이디 중복");

            result.put("error","이미 존재하는 아이디 입니다.");

            return result;
        }

        rawPw = String.valueOf(param.get("password"));
        encodePw = pwEncoder.encode(rawPw);
        param.put("password",encodePw);


        //회원가입 서비스 실행

        result.put("result", memberService.insertMember(param));

        logger.info("join Service 성공");

        return result;



    }
}
