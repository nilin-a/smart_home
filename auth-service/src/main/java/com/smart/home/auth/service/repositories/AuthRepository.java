package com.smart.home.auth.service.repositories;

import com.smart.home.auth.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
