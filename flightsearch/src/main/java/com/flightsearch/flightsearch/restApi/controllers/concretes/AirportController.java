package com.flightsearch.flightsearch.restApi.controllers.concretes;

import com.flightsearch.flightsearch.busines.abstracts.AirportService;
import com.flightsearch.flightsearch.entities.Airport;
import com.flightsearch.flightsearch.restApi.controllers.abstracts.IAirport;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@AllArgsConstructor
public class AirportController implements IAirport {
    private AirportService airportService;

    @Override
    @GetMapping("/getall")
    public List<Airport> getAll() {
        return this.airportService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Airport getById(@PathVariable Long id) {
        return this.airportService.getById(id);
    }

    @Override
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody Airport airport) {
        this.airportService.createAirport(airport);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, Airport airport) {
        airportService.updateAirportById(airport, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.airportService.delete(id);
    }
}
