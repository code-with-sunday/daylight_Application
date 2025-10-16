package com.project.daylightAcademy.service;

import com.project.daylightAcademy.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void deleteUser(int id);
}
