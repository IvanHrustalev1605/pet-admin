package com.example.petadmin.service.abstracts;

import com.example.petadmin.models.entity.user.Users;


import java.util.List;

public interface UserService {
    void confirmRegistration(String token);
    void register(Users user);
    List<Users> allUsers();
    Users getUserById(Long id);
    Users findByUserName(String username);

}
