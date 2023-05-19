package com.example.petadmin.controllers.rest.user;

import com.example.petadmin.exception.UserNotFoundException;
import com.example.petadmin.models.entity.user.Users;
import com.example.petadmin.service.abstracts.UserService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApiUserController {
    public final UserService userService;

    public ApiUserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAll() throws UserNotFoundException {
        if (userService.allUsers().isEmpty()) {
            throw new UserNotFoundException("Не найдено ни одного пользователя");
        }
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) throws UserNotFoundException {
        if (userService.getUserById(id) == null) {
            throw new  UserNotFoundException("Такой пользователь не найден!");
        }
        return new ResponseEntity<Users>(userService.getUserById(id), HttpStatus.OK);
    }
}
