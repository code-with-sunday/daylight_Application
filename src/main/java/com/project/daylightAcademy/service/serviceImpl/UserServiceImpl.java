package com.project.daylightAcademy.service.serviceImpl;

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
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.getPhoneNumber();

        User user1 = userRepository.save(user);

        return userMapper.mapToDto(user1);
    }

    @Override
    public void updateUser(UserDto userDto) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
