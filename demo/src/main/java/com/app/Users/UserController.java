package com.app.Users;

import com.app.Users.data.request.UserRequest;
import com.app.Users.data.response.UserResponse;
import com.app.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserResponse getUserProfile(@PathVariable String id) {
        return userService.getUserProfile(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUserProfile(@PathVariable String id, @RequestBody UserRequest userRequest) {
        return userService.updateUserProfile(id, userRequest);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/borrowing-history")
    public UserResponse getUserBorrowingHistory(@PathVariable String id) {
        return userService.getUserBorrowingHistory(id);
    }
}
