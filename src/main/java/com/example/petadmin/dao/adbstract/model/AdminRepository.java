package com.example.petadmin.dao.adbstract.model;

import com.example.petadmin.models.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Users, Long> {
}
