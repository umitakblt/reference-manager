package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.AircraftRequestDTO;
import com.umitakbulut.reference_manager.dto.response.AircraftResponseDTO;
import com.umitakbulut.reference_manager.service.AircraftService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping
    public List<AircraftResponseDTO> getAllAircrafts() {
        return aircraftService.getAll();
    }

    @GetMapping("/{id}")
    public AircraftResponseDTO getAircraftById(@PathVariable Long id) {
        return aircraftService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AircraftResponseDTO createAircraft(@RequestBody @Valid AircraftRequestDTO requestDTO) {
        return aircraftService.save(requestDTO);
    }

    @PutMapping("/{id}")
    public AircraftResponseDTO updateAircraft(@PathVariable Long id, @RequestBody @Valid AircraftRequestDTO requestDTO) {
        return aircraftService.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.delete(id);
    }
}
