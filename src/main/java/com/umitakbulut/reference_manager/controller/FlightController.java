package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.FlightRequestDTO;
import com.umitakbulut.reference_manager.dto.response.FlightResponseDTO;
import com.umitakbulut.reference_manager.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponseDTO> createFlight(@RequestBody FlightRequestDTO requestDTO) {
        return ResponseEntity.ok(flightService.addFlight(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponseDTO> getFlight(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @GetMapping
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponseDTO> updateFlight(@PathVariable Long id, @RequestBody FlightRequestDTO flightRequestDTO) {
        FlightResponseDTO updatedFlight = flightService.updateFlight(id, flightRequestDTO);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
