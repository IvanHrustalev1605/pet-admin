package com.example.petadmin.controllers.rest.registration;

import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.service.abstracts.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registration")
public class ApiRegistrationController {
    public final UserService userService;

    public ApiRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody Users user) {
        userService.register(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmRegistration(@RequestParam String token) {
        userService.confirmRegistration(token);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
