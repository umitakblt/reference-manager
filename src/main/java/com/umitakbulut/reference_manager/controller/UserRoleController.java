package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.UserRoleRequestDTO;
import com.umitakbulut.reference_manager.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void assignRole(@RequestBody UserRoleRequestDTO requestDTO) {
        userRoleService.assignRole(requestDTO);
    }
}
