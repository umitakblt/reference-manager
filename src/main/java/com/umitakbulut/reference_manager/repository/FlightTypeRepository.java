package com.umitakbulut.reference_manager.repository;

import com.umitakbulut.reference_manager.entity.FlightType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTypeRepository extends JpaRepository<FlightType, Long> {
}
