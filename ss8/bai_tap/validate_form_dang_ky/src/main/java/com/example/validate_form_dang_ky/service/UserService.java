package com.example.validate_form_dang_ky.service;


import com.example.validate_form_dang_ky.dto.UserDto;
import com.example.validate_form_dang_ky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto update(UserDto user) {
       return userRepository.save(user);
    }
}
