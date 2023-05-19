package com.example.petadmin.exception;

public class UserAllreadyExistsException extends Throwable {
    public UserAllreadyExistsException(String message) {
        super(message);
    }
}
