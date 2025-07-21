package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.dto.request.RoleRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RoleResponseDTO;
import com.umitakbulut.reference_manager.entity.Role;
import com.umitakbulut.reference_manager.mapper.RoleMapper;
import com.umitakbulut.reference_manager.repository.RoleRepository;
import com.umitakbulut.reference_manager.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleResponseDTO save(RoleRequestDTO requestDTO) {
        Role role = roleMapper.toEntity(requestDTO);
        Role saved = roleRepository.save(role);
        return roleMapper.toResponseDTO(saved);
    }

    @Override
    public List<RoleResponseDTO> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        return roleMapper.toResponseDTO(role);
    }

    @Override
    public RoleResponseDTO update(Long id, RoleRequestDTO requestDTO) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        existing.setName(requestDTO.getName());
        existing.setDescription(requestDTO.getDescription());
        Role updated = roleRepository.save(existing);
        return roleMapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

}
