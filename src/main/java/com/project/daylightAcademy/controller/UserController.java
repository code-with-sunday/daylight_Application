package com.project.daylightAcademy.controller;

import com.project.daylightAcademy.dto.ApiResponse;
import com.project.daylightAcademy.dto.UserDto;
import com.project.daylightAcademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/update")
    public ApiResponse updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete")
    public ApiResponse deleteUser(@RequestBody Map<String, Long> payload) {
        Long id = payload.get("id");
        return userService.deleteUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
