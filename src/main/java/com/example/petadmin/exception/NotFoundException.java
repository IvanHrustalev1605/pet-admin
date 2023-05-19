package com.example.petadmin.exception;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("Не найдено!");
    }
}
