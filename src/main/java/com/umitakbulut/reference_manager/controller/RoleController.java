package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.RoleRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RoleResponseDTO;
import com.umitakbulut.reference_manager.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleResponseDTO> getAllRoles() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public RoleResponseDTO getRoleById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleResponseDTO createRole(@RequestBody RoleRequestDTO requestDTO) {
        return roleService.save(requestDTO);
    }

    @PutMapping("/{id}")
    public RoleResponseDTO updateRole(@PathVariable Long id, @RequestBody RoleRequestDTO requestDTO) {
        return roleService.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
