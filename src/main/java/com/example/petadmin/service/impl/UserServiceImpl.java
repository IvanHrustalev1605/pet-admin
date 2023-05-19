package com.example.petadmin.service.impl;

import com.example.petadmin.dao.adbstract.model.UserDao;
import com.example.petadmin.exception.UserAllreadyExistsException;
import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.models.entity.verifyToken.VerificationToken;
import com.example.petadmin.service.abstracts.EmailService;
import com.example.petadmin.service.abstracts.UserService;
import com.example.petadmin.service.abstracts.VerificationTokenService;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final VerificationTokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final EmailMessageImpl emailMessage;
    private final EmailService emailService;
    public UserServiceImpl(UserDao userDao, VerificationTokenService tokenService, PasswordEncoder passwordEncoder, EmailMessageImpl emailMessage, EmailService emailService) {
        this.userDao = userDao;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.emailMessage = emailMessage;
        this.emailService = emailService;
    }

    @Override
    public void confirmRegistration(String token) {
        VerificationToken verificationToken = tokenService.findTokenByToken(token);
        if (verificationToken != null) {
            Users user = tokenService.findUserByToken(token);
            user.setEnabled(true);
            userDao.save(user);
        }
    }

    @Override
    @SneakyThrows
    @Transactional
    public void register(Users user) {
        if (userDao.findByEmail(user.getEmail()) != null) {
            throw new UserAllreadyExistsException("Такой пользователь уже зарегистрирован!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        String token = tokenService.create(user);
        emailMessage.getMailMessage(user.getEmail(), user.getEmail(), "Complete Registration",
                "To confirm your account, please click here : "
                        +"http://localhost:8080/confirm-account?token=" + token);
        emailService.sendMail(emailMessage);
    }

    @Override
    public List<Users> allUsers() {
        return userDao.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public Users findByUserName(String username) {
        return null;
    }

}
