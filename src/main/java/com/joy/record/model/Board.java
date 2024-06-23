package com.joy.record.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Board {
    private int board_id;
    private String title;
    private String board_text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String joy_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String created_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String modified_date;
    private char del_yn;
    private int member_id;

    private int joy_id;
    private String joy_name;
    private String user_id;
    private String name;

    private int file_id;

}
