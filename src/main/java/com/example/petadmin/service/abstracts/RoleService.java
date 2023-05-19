package com.example.petadmin.service.abstracts;

import com.example.petadmin.models.entity.user.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();
    public void addRole(Role role);
    public Role findByName(String name);
    public void deleteRoleByName(String name);
}
