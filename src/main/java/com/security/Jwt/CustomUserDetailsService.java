package com.security.Jwt;

import com.joy.record.mapper.MemberMapper;
import com.joy.record.model.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberMapper memberMapper;
    private final ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        System.out.println("git test");
        Member member = memberMapper.selectMemberOne(Integer.parseInt(id))
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 없습니다."));

        Member dto = mapper.map(member, Member.class);

        return new CustomUserDetails(dto);
    }
}