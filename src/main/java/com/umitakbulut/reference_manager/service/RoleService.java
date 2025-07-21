package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.RoleRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    RoleResponseDTO save(RoleRequestDTO requestDTO);

    List<RoleResponseDTO> getAll();

    RoleResponseDTO getById(Long id);

    RoleResponseDTO update(Long id, RoleRequestDTO requestDTO);

    void delete(Long id);
}
