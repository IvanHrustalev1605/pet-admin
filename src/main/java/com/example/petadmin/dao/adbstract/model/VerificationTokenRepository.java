package com.example.petadmin.dao.adbstract.model;

import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.models.entity.verifyToken.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Users findUserByToken(VerificationToken token);

}
