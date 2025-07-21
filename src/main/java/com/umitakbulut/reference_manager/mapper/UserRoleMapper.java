package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.response.UserRoleResponseDTO;
import com.umitakbulut.reference_manager.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "role", source = "role")
    UserRoleResponseDTO toResponseDto(UserRole userRole);
}