package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.FlightTypeRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightTypeResponseDTO;
import com.umitakbulut.reference_manager.service.FlightTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flighttypes")
@RequiredArgsConstructor
public class FlightTypeController {

    private final FlightTypeService flightTypeService;

    @GetMapping
    public List<FlightTypeResponseDTO> getAllFlightTypes() {
        return flightTypeService.getAll();
    }

    @GetMapping("/{id}")
    public FlightTypeResponseDTO getFlightTypeById(@PathVariable Long id) {
        return flightTypeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightTypeResponseDTO createFlightType(@RequestBody FlightTypeRequestDTO requestDTO) {
        return flightTypeService.save(requestDTO);
    }

    @PutMapping("/{id}")
    public FlightTypeResponseDTO updateFlightType(@PathVariable Long id, @RequestBody FlightTypeRequestDTO requestDTO) {
        return flightTypeService.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlightType(@PathVariable Long id) {
        flightTypeService.delete(id);
    }
}
