package com.flightsearch.flightsearch.dataAccess.abstracts;

import com.flightsearch.flightsearch.entities.Airport;
import com.flightsearch.flightsearch.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    boolean existsById(Long id);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeGreaterThanEqual(Airport departure,
                                                                                             Airport arrival,
                                                                                             LocalDateTime departureDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeGreaterThanEqualAndReturnDateTimeLessThanEqual(Airport departure,
                                                                                                                           Airport arrival,
                                                                                                                           LocalDateTime departureDateTime,
                                                                                                                           LocalDateTime returnDateTime);
}
