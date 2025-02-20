package com.security.Jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    // ObjectMapper는 JSON으로 직렬화하는데 사용
    public JwtAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        // 401 상태 코드 설정
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // 응답 데이터 (JSON 형태로 에러 메시지 추가)
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("message", "Unauthorized: Invalid credentials");

        // JSON 직렬화
        String jsonResponse = objectMapper.writeValueAsString(body);

        // Content-Type을 application/json으로 설정하고 응답에 메시지 반환
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }
}
