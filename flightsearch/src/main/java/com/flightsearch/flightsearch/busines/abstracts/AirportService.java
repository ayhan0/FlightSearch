package com.flightsearch.flightsearch.busines.abstracts;

import com.flightsearch.flightsearch.entities.Airport;

import java.util.List;

public interface AirportService {
    List<Airport> getAll();

    Airport getById(Long id);

    void createAirport(Airport createCommentRequest);

    void updateAirportById(Airport airport, Long id);

    void delete(Long id);
}
