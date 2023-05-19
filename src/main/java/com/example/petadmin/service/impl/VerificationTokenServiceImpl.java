package com.example.petadmin.service.impl;

import com.example.petadmin.dao.adbstract.model.VerificationTokenRepository;
import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.models.entity.verifyToken.VerificationToken;
import com.example.petadmin.service.abstracts.VerificationTokenService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private final VerificationTokenRepository tokenRepository;

    public VerificationTokenServiceImpl(VerificationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public String create(Users user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        tokenRepository.save(verificationToken);
        return verificationToken.getToken();
    }

    @Override
    public VerificationToken findTokenByToken(String token) {
        return null;
    }

    @Override
    public Users findUserByToken(String token) {
       return entityManager.createQuery("""
                                FROM Users u
                                JOIN VerificationToken as vt on vt.token =: token
                                WHERE u.id = vt.id
                                """, Users.class)
                .setParameter("token", token)
                .getSingleResult();
    }

}
