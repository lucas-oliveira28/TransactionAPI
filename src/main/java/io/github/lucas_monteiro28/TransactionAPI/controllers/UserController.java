package io.github.lucas_monteiro28.TransactionAPI.controllers;

import io.github.lucas_monteiro28.TransactionAPI.dto.request.UserRequestDTO;
import io.github.lucas_monteiro28.TransactionAPI.dto.response.UserResponseDTO;
import io.github.lucas_monteiro28.TransactionAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserRequestDTO dto) {
        userService.saveUser(dto);
        return ResponseEntity.ok("User saved successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

}
