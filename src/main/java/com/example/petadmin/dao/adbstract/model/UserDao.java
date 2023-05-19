package com.example.petadmin.dao.adbstract.model;

import com.example.petadmin.models.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM Users u WHERE u.email = ?", nativeQuery = true)
    Users findByEmail(String email);
}
