package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.RegisterRequestDTO;
import com.umitakbulut.reference_manager.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO registerUser(RegisterRequestDTO requestDTO);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();

    void deleteUser(Long id);
}
