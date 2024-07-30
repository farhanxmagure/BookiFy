package com.app.Users.data.response;

import com.app.Users.data.User;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private List<User.BorrowingHistory> borrowingHistory;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.borrowingHistory = user.getBorrowingHistory();
    }
}
