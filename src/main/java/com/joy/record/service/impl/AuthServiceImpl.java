package com.joy.record.service.impl;

import com.joy.record.mapper.MemberMapper;
import com.joy.record.model.LoginRequestDto;
import com.joy.record.model.Member;
import com.joy.record.service.AuthService;
import com.security.Jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@ComponentScan(basePackages = {"com.security"})
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public HashMap<String, Object> login(LoginRequestDto dto) {
        
        System.out.println("AuthServiceImpl - login");
        String userid = dto.getUser_id();
        String password = dto.getPassword();

        Member member = memberMapper.findByUsername(userid);
        if(member == null) {
            throw new UsernameNotFoundException("아이디가 존재하지 않습니다.");
        }

        // 암호화된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
        if(!encoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        Member info = modelMapper.map(member, Member.class);

        System.out.println("info");
        System.out.println(info);

        String accessToken = jwtUtil.createAccessToken(info);

        HashMap<String, Object> memData = new HashMap<>();
        memData.put("token" , accessToken);
        memData.put("user_id" , info.getUser_id());
        memData.put("user_role" , info.getRole());


        return memData;
    }
}
