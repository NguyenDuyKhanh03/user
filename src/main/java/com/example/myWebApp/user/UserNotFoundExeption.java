package com.example.myWebApp.user;

public class UserNotFoundExeption extends Throwable {
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
