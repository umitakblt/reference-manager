package com.umitakbulut.reference_manager.mapper;

import com.umitakbulut.reference_manager.dto.request.RegisterRequestDTO;
import com.umitakbulut.reference_manager.dto.response.UserResponseDTO;
import com.umitakbulut.reference_manager.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void shouldMapRegisterRequestToUserEntity() {
        RegisterRequestDTO request = new RegisterRequestDTO();
        request.setEmail("umit@example.com");
        request.setUsername("umit");

        User user = userMapper.toEntity(request);

        assertEquals("umit@example.com", user.getEmail());
        assertEquals("umit", user.getUsername());
        assertNull(user.getPassword());
    }

    @Test
    void shouldMapUserEntityToUserDto() {
        User user = new User();
        user.setEmail("umit@example.com");
        user.setUsername("umit");

        UserResponseDTO dto = userMapper.toDto(user);

        assertEquals("umit@example.com", dto.getEmail());
        assertEquals("umit", dto.getUsername());
    }
}
