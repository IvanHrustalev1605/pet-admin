package com.example.petadmin.dao.adbstract.model;

import com.example.petadmin.models.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
