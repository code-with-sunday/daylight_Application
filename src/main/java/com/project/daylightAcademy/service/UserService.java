package com.project.daylightAcademy.service;

import com.project.daylightAcademy.dto.ApiResponse;
import com.project.daylightAcademy.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
    ApiResponse updateUser(UserDto userDto);
    ApiResponse deleteUser(Long id);
}
