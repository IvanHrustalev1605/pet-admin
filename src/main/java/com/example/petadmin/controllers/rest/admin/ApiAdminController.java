package com.example.petadmin.controllers.rest.admin;

import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.service.abstracts.AdminService;
import com.example.petadmin.service.abstracts.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ApiAdminController {
    private final AdminService adminService;
    private final UserService userService;
    public ApiAdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }
    @GetMapping("/getUser?{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return new ResponseEntity<Users>(userService.getUserById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveUser(@RequestBody Users user) {
        adminService.create(user);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }
}
