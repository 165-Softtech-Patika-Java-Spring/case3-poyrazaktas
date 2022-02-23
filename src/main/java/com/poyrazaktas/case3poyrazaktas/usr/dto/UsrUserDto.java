package com.poyrazaktas.case3poyrazaktas.usr.dto;

import com.poyrazaktas.case3poyrazaktas.usr.enums.UsrUserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsrUserDto {
    private String userName;

    private String email;

    private String phone;

    private UsrUserType userType;
}
