package com.example.petadmin.service.impl;

import com.example.petadmin.dao.adbstract.model.AdminRepository;
import com.example.petadmin.dao.adbstract.model.UserDao;
import com.example.petadmin.exception.UserAllreadyExistsException;
import com.example.petadmin.exception.UserNotFoundException;
import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.service.abstracts.AdminService;
import com.example.petadmin.service.abstracts.UserService;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userRepository;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder, UserService userRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void update(Users user) {

    }
    @SneakyThrows
    @Transactional
    @Override
    public void delete(Long id) {
        if (userRepository.getUserById(id) != null) {
            throw new UserNotFoundException("Такой пользователь не найден!");
        }
        adminRepository.delete(userRepository.getUserById(id));
    }
    @Transactional
    @Override
    @SneakyThrows
    public void create(Users user) {
        if (userRepository.findByUserName(user.getUsername()) != null) {
            throw new UserAllreadyExistsException("Такой пользователь уже существует");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        adminRepository.save(user);
    }

    @Override
    public void banUser(Users user) {
        user.setBanned();
    }
}
