package com.umitakbulut.reference_manager.service;

import com.umitakbulut.reference_manager.dto.request.UserRoleRequestDTO;
import com.umitakbulut.reference_manager.dto.response.UserRoleResponseDTO;

import java.util.List;

public interface UserRoleService {
    UserRoleResponseDTO assignRole(UserRoleRequestDTO dto);
    List<UserRoleResponseDTO> getAllUserRoles();
}