package com.project.daylightAcademy.service.serviceImpl;

import com.project.daylightAcademy.dto.ApiResponse;
import com.project.daylightAcademy.dto.UserDto;
import com.project.daylightAcademy.entity.User;
import com.project.daylightAcademy.mapper.UserMapper;
import com.project.daylightAcademy.repository.UserRepository;
import com.project.daylightAcademy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setId(user.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());

        User user1 = userRepository.save(user);

        return userMapper.mapToDto(user1);
    }

    @Override
    public ApiResponse updateUser(UserDto userDto) {
        User user = new User();
        ApiResponse apiResponse = new ApiResponse();

        if (userRepository.findById(userDto.getId()).isEmpty()) {
            apiResponse.setMessage("user not found");
            apiResponse.setStatus("404");
            return apiResponse;
        }

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userRepository.save(user);

        apiResponse.setMessage("success");
        apiResponse.setStatus("200");
        return apiResponse;

    }

    @Override
    public ApiResponse deleteUser(Long id) {
        ApiResponse apiResponse = new ApiResponse();

        if (userRepository.findById(id).isEmpty()) {
            apiResponse.setMessage("user not found");
            apiResponse.setStatus("404");
            return apiResponse;
        }

        userRepository.deleteById(id);

        apiResponse.setMessage("success");
        apiResponse.setStatus("200");
        return apiResponse;
    }
}
