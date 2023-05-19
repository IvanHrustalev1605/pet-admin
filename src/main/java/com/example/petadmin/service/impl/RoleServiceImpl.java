package com.example.petadmin.service.impl;

import com.example.petadmin.dao.adbstract.model.RoleRepository;
import com.example.petadmin.models.entity.user.Role;
import com.example.petadmin.service.abstracts.RoleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @PersistenceContext
    public EntityManager entityManager;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("""
                        FROM Role r
                        WHERE r.name =: name
                             """, Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void deleteRoleByName(String name) {
        entityManager.createQuery("""
                    DELETE Role r
                    where r.name =: name
                    """, Role.class)
                .setParameter("name", name);
    }
}
