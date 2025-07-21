package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.RegisterRequestDTO;
import com.umitakbulut.reference_manager.dto.response.UserResponseDTO;
import com.umitakbulut.reference_manager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return userService.registerUser(registerRequestDTO);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody RegisterRequestDTO requestDTO) {
        return userService.updateUser(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}