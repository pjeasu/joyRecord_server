package com.joy.record.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Member {
    private int member_id;
    private String user_id;
    private String password;
    private String user_name;
    private String del_yn;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime birth;
    private String email;
    private int file_id;

    private String Role;
}
