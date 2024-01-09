package com.flightsearch.flightsearch.busines.concretes;

import com.flightsearch.flightsearch.busines.abstracts.AirportService;
import com.flightsearch.flightsearch.dataAccess.abstracts.AirportRepository;
import com.flightsearch.flightsearch.entities.Airport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class AirportManager implements AirportService {
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    @Override
    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public void updateAirportById(Airport updatedAirport, Long id) {

        Airport existingAirport = airportRepository.findById(id).orElse(null);

        if (existingAirport == null) {
            return;
        }

        existingAirport.setCity(updatedAirport.getCity());
        airportRepository.save(existingAirport);
    }


    @Override
    public void delete(Long id) {
        this.airportRepository.deleteById(id);

    }
}
