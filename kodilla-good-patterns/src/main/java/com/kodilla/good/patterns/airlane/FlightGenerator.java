package com.kodilla.good.patterns.airlane;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FlightGenerator {

    private Set<Flights> listOfFlights = new HashSet<Flights>();

    public Set<Flights> addLine(Flights flights) {

        listOfFlights.add(flights);
        return listOfFlights;
    }

    public Set<Flights> getListOfFlights() {
        return Collections.unmodifiableSet(listOfFlights);
    }
}
