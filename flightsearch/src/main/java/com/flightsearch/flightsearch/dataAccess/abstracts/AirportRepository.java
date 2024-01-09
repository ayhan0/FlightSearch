package com.flightsearch.flightsearch.dataAccess.abstracts;

import com.flightsearch.flightsearch.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
