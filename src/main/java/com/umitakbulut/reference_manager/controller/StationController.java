package com.umitakbulut.reference_manager.controller;

import com.umitakbulut.reference_manager.dto.request.StationRequestDTO;
import com.umitakbulut.reference_manager.dto.response.StationResponseDTO;
import com.umitakbulut.reference_manager.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StationResponseDTO createStation(@RequestBody StationRequestDTO requestDTO) {
        return stationService.save(requestDTO);
    }

    @GetMapping
    public List<StationResponseDTO> getAllStations() {
        return stationService.getAll();
    }

    @GetMapping("/{id}")
    public StationResponseDTO getStationById(@PathVariable Long id) {
        return stationService.getById(id);
    }

    @PutMapping("/{id}")
    public StationResponseDTO updateStation(@PathVariable Long id, @RequestBody StationRequestDTO requestDTO) {
        return stationService.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStation(@PathVariable Long id) {
        stationService.delete(id);
    }
}
