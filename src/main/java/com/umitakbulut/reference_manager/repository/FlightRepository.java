package com.umitakbulut.reference_manager.repository;

import com.umitakbulut.reference_manager.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f.flightNumber FROM Flight f WHERE f.flightNumber IN :flightNumbers")
    List<String> findExistingFlightNumbers(@Param("flightNumbers") List<String> flightNumbers);
}
