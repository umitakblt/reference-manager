package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.RouteRequestDTO;
import com.umitakbulut.reference_manager.dto.response.RouteResponseDTO;
import com.umitakbulut.reference_manager.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public List<RouteResponseDTO> getAllRoutes() {
        return routeService.getAll();
    }

    @GetMapping("/{id}")
    public RouteResponseDTO getRouteById(@PathVariable Long id) {
        return routeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RouteResponseDTO createRoute(@RequestBody RouteRequestDTO requestDTO) {
        return routeService.save(requestDTO);
    }

    @PutMapping("/{id}")
    public RouteResponseDTO updateRoute(@PathVariable Long id, @RequestBody RouteRequestDTO requestDTO) {
        return routeService.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoute(@PathVariable Long id) {
        routeService.delete(id);
    }
}
