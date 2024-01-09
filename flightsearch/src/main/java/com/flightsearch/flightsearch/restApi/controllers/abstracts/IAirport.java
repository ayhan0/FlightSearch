package com.flightsearch.flightsearch.restApi.controllers.abstracts;

import com.flightsearch.flightsearch.entities.Airport;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IAirport {
    //GetMappings
    @GetMapping("/getall")
    public List<Airport> getAll();

    @GetMapping("/{id}")
    public Airport getById(@PathVariable Long id);

    //PostMappings
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid Airport createCommentRequest);

    @PutMapping("/{id}")
    public void update(@RequestBody() @PathVariable Long id, Airport airport);

    //DeleteMappings
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id);
}
