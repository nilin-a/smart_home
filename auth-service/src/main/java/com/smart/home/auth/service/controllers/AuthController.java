package com.smart.home.auth.service.controllers;

import com.smart.home.auth.service.dtos.LoginDto;
import com.smart.home.auth.service.dtos.LoginResponse;
import com.smart.home.auth.service.entities.User;
import com.smart.home.auth.service.security.JWTUtil;
import com.smart.home.auth.service.services.AuthService;
import com.smart.home.auth.service.services.UserInfoConfigManager;
import com.smart.home.auth.service.utils.ResponseHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserInfoConfigManager userInfoConfigManager;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody LoginDto loginDto) {
        return ResponseHandler.generateResponse("Пользователь зарегистрирован", HttpStatus.OK, authService.register(loginDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDTO) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
            User user = (User) userInfoConfigManager.loadUserByUsername(loginDTO.getUsername());
            String jwt = jwtUtil.generateToken(user);
            LoginResponse loginResponse = LoginResponse
                    .builder()
                    .accessToken(jwt)
                    .build();
            return ResponseHandler.generateResponse("User logged in successfully", HttpStatus.OK, loginResponse);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }
}