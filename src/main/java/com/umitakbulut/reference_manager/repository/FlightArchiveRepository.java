package com.umitakbulut.reference_manager.repository;

import com.umitakbulut.reference_manager.entity.FlightArchive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightArchiveRepository extends JpaRepository<FlightArchive, Long> {
}
