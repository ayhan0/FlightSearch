package com.flightsearch.flightsearch.restApi.controllers.concretes;

import com.flightsearch.flightsearch.busines.abstracts.FlightService;
import com.flightsearch.flightsearch.entities.Airport;
import com.flightsearch.flightsearch.entities.Flight;
import com.flightsearch.flightsearch.restApi.controllers.abstracts.IFlight;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flight")
@AllArgsConstructor
public class FlightController implements IFlight {
    private FlightService flightService;

    @Override
    @GetMapping("/getall")
    public List<Flight> getAll() {
        return this.flightService.getAll();
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam Airport departure,
            @RequestParam Airport arrival,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime) {

        return flightService.searchFlights(departure, arrival, departureDateTime, returnDateTime);
    }

    @Override
    @GetMapping("/{id}")
    public Flight getById(@PathVariable Long id) {
        return this.flightService.getById(id);
    }

    @Override
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody Flight flight) {
        this.flightService.createFlight(flight);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, Flight flight) {
        flightService.updateFlightById(flight, id);
    }


    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.flightService.delete(id);
    }
}
