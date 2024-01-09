package com.flightsearch.flightsearch.busines.abstracts;

import com.flightsearch.flightsearch.entities.Airport;
import com.flightsearch.flightsearch.entities.Flight;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> getAll();

    Flight getById(Long id);

    void createFlight(Flight flight);

    void updateFlightById(Flight flight, Long id);

    void delete(Long id);

    List<Flight> searchFlights(Airport departure, Airport arrival, LocalDateTime departureDateTime, LocalDateTime returnDateTime);


}
