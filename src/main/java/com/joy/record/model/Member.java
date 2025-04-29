package com.joy.record.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private int member_id;
    private String user_id;
    private String password;
    private String user_name;
    private String del_yn;
    private LocalDateTime birth;
    private String email;
    private int file_id;

    private String Role;
}
