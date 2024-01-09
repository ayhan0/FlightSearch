package com.flightsearch.flightsearch.busines.abstracts;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightsearch.flightsearch.dataAccess.abstracts.FlightRepository;
import com.flightsearch.flightsearch.entities.Flight;

@Service
public class FlighDataService {
	 @Autowired
	    private FlightRepository flightRepository;

	    // Mock bir API'dan uçuş bilgilerini al ve veritabanına kaydet
	    public void fetchDataAndSaveToDatabase() {
	        
	        List<Flight> mockFlightData = mockApiRequest(); 
	        saveFlightsToDatabase(mockFlightData);
	    }

	    private List<Flight> mockApiRequest() {
	       // Example of dataset 
	        return List.of(
	                );
	    }

	    private void saveFlightsToDatabase(List<Flight> flights) {
	        // Veritabanına uçuşları kaydet
	        flightRepository.saveAll(flights);
	    }
}
