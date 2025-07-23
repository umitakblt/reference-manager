package com.umitakbulut.reference_manager.service.impl;

import com.umitakbulut.reference_manager.entity.Flight;
import com.umitakbulut.reference_manager.entity.FlightArchive;
import com.umitakbulut.reference_manager.mapper.FlightArchiveMapper;
import com.umitakbulut.reference_manager.repository.FlightArchiveRepository;
import com.umitakbulut.reference_manager.service.FlightArchiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightArchiveServiceImpl implements FlightArchiveService {

    private final FlightArchiveRepository repository;

    @Qualifier("flightArchiveMapper")
    private final FlightArchiveMapper flightArchiveMapper;

    @Override
    public void saveFromFlight(Flight flight) {
        FlightArchive archive = flightArchiveMapper.fromFlight(flight);
        repository.save(archive);
    }
}
