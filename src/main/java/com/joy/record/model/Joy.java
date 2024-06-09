package com.joy.record.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Joy {
    private int joy_id;
    private String name;
    private String detail;
    private String del_yn;
    private int member_id;
}
