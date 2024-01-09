package com.flightsearch.flightsearch.busines.concretes;

import com.flightsearch.flightsearch.busines.abstracts.FlightService;
import com.flightsearch.flightsearch.dataAccess.abstracts.AirportRepository;
import com.flightsearch.flightsearch.dataAccess.abstracts.FlightRepository;
import com.flightsearch.flightsearch.entities.Airport;
import com.flightsearch.flightsearch.entities.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class FlightManager implements FlightService {
    private FlightRepository flightRepository;
    private AirportManager airportManager;


    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public void createFlight(Flight flight) {
        flight.setDepartureAirport(airportManager.getById(flight.getDepartureAirport().getId()));
        flight.setArrivalAirport(airportManager.getById(flight.getArrivalAirport().getId()));

        flightRepository.save(flight);
    }


    @Override
    public void updateFlightById(Flight updatedFlight, Long id) {
        Flight existingFlight = flightRepository.findById(id).orElse(null);

        if (existingFlight == null) {
            return;
        }

        updatedFlight.setId(existingFlight.getId());

        flightRepository.save(updatedFlight);
    }


    @Override
    public void delete(Long id) {
        this.flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> searchFlights(Airport departure, Airport arrival, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        if (returnDateTime == null) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeGreaterThanEqual(departure, arrival, departureDateTime);
        } else {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeGreaterThanEqualAndReturnDateTimeLessThanEqual(
                    departure, arrival, departureDateTime, returnDateTime);
        }
    }


}
