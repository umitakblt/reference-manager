package com.umitakbulut.reference_manager.repository;

import com.umitakbulut.reference_manager.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}
