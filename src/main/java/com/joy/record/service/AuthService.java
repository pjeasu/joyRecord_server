package com.joy.record.service;

import com.joy.record.model.LoginRequestDto;

import java.util.HashMap;
import java.util.Objects;

public interface AuthService {
    public HashMap<String, Object> login(LoginRequestDto dto) ;
}