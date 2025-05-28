package io.github.Ital023.Ecommerce_FBR_MySQL.controller;

import io.github.Ital023.Ecommerce_FBR_MySQL.controller.dto.CreateUserDto;
import io.github.Ital023.Ecommerce_FBR_MySQL.entities.UserEntity;
import io.github.Ital023.Ecommerce_FBR_MySQL.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto dto) {
        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findById(@PathVariable("userId")UUID userId) {
        var user = userService.findById(userId);

        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }


}
