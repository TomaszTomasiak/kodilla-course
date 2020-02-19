package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;


public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightTo = new HashMap<>();
        flightTo.put("Warsaw", true);

        for (Map.Entry<String, Boolean> entry : flightTo.entrySet()) {
            if (entry.getKey() != flight.getArrivalAirport()) {
                System.out.println("The airport does not exist");
                throw new RouteNotFoundException();
            }
        }
    }
}
