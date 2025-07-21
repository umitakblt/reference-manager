package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.RoleRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RoleResponseDTO;
import com.umitakbulut.reference_manager.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleRequestDTO dto);
    RoleResponseDTO toResponseDTO(Role role);
}
