package com.app.Security.data.request;

import lombok.Data;


@Data
public class LoginRequest {

    private String username;
    private String password;
}
