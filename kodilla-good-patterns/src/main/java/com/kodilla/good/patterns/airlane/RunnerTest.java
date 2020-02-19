package com.kodilla.good.patterns.airlane;

public class RunnerTest {

    public static void main(String[] args) {
        FlightGenerator flightGenerator = FlightsRetriever.retrieve();
        FlightsResearcher flightsResearcher = new FlightsResearcher(flightGenerator.getListOfFlights());

        flightsResearcher.searchDirectConnectionsFromTo("Poznań", "Warszawa");
        flightsResearcher.searchDirectLinesByPortOfDeparture("Gdańsk");
        flightsResearcher.searchDirectLinesByPortOfDestination("Poznań");
        flightsResearcher.searchConnectionsFromToWithInterchange("Gdańsk", "Szczecin", "Warszawa");
    }
}
