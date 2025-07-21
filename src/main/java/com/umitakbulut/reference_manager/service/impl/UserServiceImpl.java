package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.RegisterRequestDTO;
import com.umitakbulut.reference_manager.dto.response.UserResponseDTO;
import com.umitakbulut.reference_manager.entity.User;
import com.umitakbulut.reference_manager.mapper.UserMapper;
import com.umitakbulut.reference_manager.repository.UserRepository;
import com.umitakbulut.reference_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO registerUser(RegisterRequestDTO requestDTO) {
        User user = userMapper.toEntity(requestDTO);
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, RegisterRequestDTO requestDTO) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User updated = userMapper.toEntity(requestDTO);
        updated.setId(existing.getId());
        User saved = userRepository.save(updated);
        return userMapper.toDto(saved);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}