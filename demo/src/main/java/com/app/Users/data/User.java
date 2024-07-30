package com.app.Users.data;

import com.app.Security.data.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private List<BorrowingHistory> borrowingHistory;

    @Data
    public static class BorrowingHistory {
        private String bookId;
        private String bookTitle;
        private String borrowedDate;
        private String returnedDate;
    }

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
