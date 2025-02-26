package com.joy.record.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Joy {
    private int joy_id;
    private String joy_name;
    private String detail;
    private String del_yn;

    private int member_id;
    private String color;

    // 조이차트
    private int count;
    private String month;

}
