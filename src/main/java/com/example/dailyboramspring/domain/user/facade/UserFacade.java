package com.example.dailyboramspring.domain.user.facade;

import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.domain.repository.UserRepository;
import com.example.dailyboramspring.domain.user.exception.UserNotFoundException;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserById(email);
    }

    public User getUserById(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
