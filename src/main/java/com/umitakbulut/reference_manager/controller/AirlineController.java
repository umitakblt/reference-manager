package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.AirlineRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AirlineResponseDTO;
import com.umitakbulut.reference_manager.service.AirlineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping
    public List<AirlineResponseDTO> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public AirlineResponseDTO getAirlineById(@PathVariable Long id) {
        return airlineService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirlineResponseDTO createAirline(@RequestBody @Valid AirlineRequestDTO requestDTO) {
        return airlineService.save(requestDTO);
    }

    @PutMapping("/{id}")
    public AirlineResponseDTO updateAirline(@PathVariable Long id, @RequestBody @Valid AirlineRequestDTO requestDTO) {
        return airlineService.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirline(@PathVariable Long id) {
        airlineService.delete(id);
    }
}
