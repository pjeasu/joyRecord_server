package com.joy.record.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joy.record.model.LoginRequestDto;
import com.joy.record.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthApiController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> getMemberProfile(
            @Valid @RequestBody LoginRequestDto request
    ) throws JsonProcessingException {
        HashMap<String, Object> memData = new HashMap<>();
        memData = this.authService.login(request);

        ObjectMapper objectMapper = new ObjectMapper();         // Map -> Json 문자열
        String JsonData = objectMapper.writeValueAsString(memData);

        return ResponseEntity.status(HttpStatus.OK).body(JsonData);
    }

    /** 회원정보 수정 시, 기존 비밀번호 체크 */
    @PostMapping("/checkPassword")
    public boolean checkPassword(@Valid @RequestBody LoginRequestDto request)  {
        boolean check = this.authService.checkPassword(request);
        return check;
    }
}