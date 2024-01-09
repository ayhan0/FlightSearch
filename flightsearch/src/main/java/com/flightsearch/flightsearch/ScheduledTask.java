package com.flightsearch.flightsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.flightsearch.flightsearch.busines.abstracts.FlighDataService;

@Component
public class ScheduledTask {

    @Autowired
    private FlighDataService flightDataService;

    @Scheduled(cron = "0 0 0 * * *")
    public void fetchAndSaveFlightData() {
        flightDataService.fetchDataAndSaveToDatabase();
    }
}
