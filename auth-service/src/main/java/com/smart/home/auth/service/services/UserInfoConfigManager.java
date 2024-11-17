package com.smart.home.auth.service.services;

import com.smart.home.auth.service.entities.User;
import com.smart.home.auth.service.repositories.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoConfigManager implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findByLogin(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}