package com.app.Users.service;

import com.app.Users.data.User;
import com.app.Users.data.request.UserRequest;
import com.app.Users.data.response.UserResponse;
import com.app.Users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse getUserProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user);
    }

    public UserResponse updateUserProfile(String userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse getUserBorrowingHistory(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user);
    }
}
