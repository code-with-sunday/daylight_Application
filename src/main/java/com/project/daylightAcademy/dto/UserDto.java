package com.project.daylightAcademy.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
}
