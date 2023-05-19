package com.example.petadmin.service.abstracts;

import com.example.petadmin.models.entity.user.Users;

public interface AdminService {
    public void update(Users user);
    public void delete(Long id);
    public void create(Users user);
    public void banUser(Users user);
}
