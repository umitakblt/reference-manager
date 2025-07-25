package com.umitakbulut.reference_manager.repository;

import com.umitakbulut.reference_manager.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
