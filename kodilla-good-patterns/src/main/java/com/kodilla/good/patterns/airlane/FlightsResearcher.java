package com.kodilla.good.patterns.airlane;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightsResearcher {

    Scanner sc = new Scanner(System.in);

    private Set<Flights> listOfFlights;

    public FlightsResearcher(Set<Flights> listOfFlights) {
        this.listOfFlights = listOfFlights;
    }

    public void searchDirectLinesByPortOfDeparture(String departure) {
        System.out.println("\nBezpośrednie rejsy z lotniska: " + departure + ":\n");
        listOfFlights.stream()
                .filter(e -> e.getDeparturePort().equals(departure))
                .map(Flights::toString)
                .forEach(System.out::println);
    }

    public void searchDirectLinesByPortOfDestination(String arrival) {

        System.out.println("\nBezpośrednie rejsy do: " + arrival + ":\n ");
        listOfFlights.stream()
                .filter(e -> e.getDestinationPort().equals(arrival))
                .map(Flights::toString)
                .forEach(System.out::println);
    }

    public void searchDirectConnectionsFromTo(String departure, String arrival) {
        System.out.println("\nBezpośrednie połączenia z lotniska: " + departure + ", do: " + arrival + ":\n");
        listOfFlights.stream()
                .filter(e -> e.getDeparturePort().equals(departure) && e.getDestinationPort().equals(arrival))
                .map(Flights::toString)
                .forEach(System.out::println);
    }

    public void searchConnectionsFromToWithInterchange(String departure, String arrival, String interchange) {

        System.out.println("\nPołączenia z lotniska: " + departure + " do: " + arrival + " z przesiadką w: " + interchange + ":\n");

        List<Flights> listOfFlightsWithInterChange = listOfFlights.stream()
                .filter(f -> f.getDeparturePort().equals(departure) && f.getDestinationPort().equals(interchange))
                .collect(Collectors.toList());
        listOfFlights.stream()
                .filter(f -> f.getDeparturePort().equals(interchange) && f.getDestinationPort().equals(arrival))
                .collect(Collectors.toCollection(() -> listOfFlightsWithInterChange));
        listOfFlightsWithInterChange.stream()
                .forEach(System.out::println);

    }
}



