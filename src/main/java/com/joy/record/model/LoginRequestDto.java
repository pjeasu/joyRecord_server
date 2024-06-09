package com.joy.record.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginRequestDto {
    @NotNull
    private String user_id;
    private String password;
}
