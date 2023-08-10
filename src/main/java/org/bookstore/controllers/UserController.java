package org.bookstore.controllers;

import org.bookstore.entities.User;
import org.bookstore.repository.UserRepository;
import org.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        boolean isUsernameInUse = userService.isUsernameInUse(user.getUsername());
        boolean isEmailInUse = userService.isEmailInUse(user.getEmail());
        boolean isValidPassword = userService.isValidPassword(user.getPassword());
        boolean isValidEmail = userService.isValidEmail(user.getEmail());
        if (!isUsernameInUse) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        } else if (isEmailInUse){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        } else if (!isValidPassword) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Password doesn't meet requirements");
        } else if (isValidEmail) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is not valid");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
        }

    @ModelAttribute("loggedIn")
    public boolean loggedIn(@AuthenticationPrincipal User user) {
        return user != null;
    }
}
