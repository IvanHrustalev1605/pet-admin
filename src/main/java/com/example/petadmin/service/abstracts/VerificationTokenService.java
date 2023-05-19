package com.example.petadmin.service.abstracts;

import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.models.entity.verifyToken.VerificationToken;

public interface VerificationTokenService {
    String create(Users user);
    VerificationToken findTokenByToken(String token);
    Users findUserByToken(String token);
}
