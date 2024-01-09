package com.flightsearch.flightsearch.restApi.controllers.abstracts;

import com.flightsearch.flightsearch.entities.Airport;
import com.flightsearch.flightsearch.entities.Flight;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

public interface IFlight {
    //GetMappings
    @GetMapping("/getall")
    public List<Flight> getAll();

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam Airport departure,
            @RequestParam Airport arrival,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime);

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Long id);

    //PostMappings
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid Flight flight);

    @PutMapping("/{id}")
    public void update(@RequestBody() @PathVariable Long id, Flight flight);

    //DeleteMappings
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id);


}