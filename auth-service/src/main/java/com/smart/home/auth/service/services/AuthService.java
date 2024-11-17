package com.smart.home.auth.service.services;

import com.smart.home.auth.service.dtos.LoginDto;
import com.smart.home.auth.service.dtos.RegisterResponse;
import com.smart.home.auth.service.entities.User;
import com.smart.home.auth.service.repositories.AuthRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public RegisterResponse register(LoginDto loginDto) {
        User user = modelMapper.map(loginDto, User.class);
        user.setPassword(passwordEncoder.encode(loginDto.getPassword()));
        User save = authRepository.save(user);
        return modelMapper.map(save, RegisterResponse.class);
    }
}
