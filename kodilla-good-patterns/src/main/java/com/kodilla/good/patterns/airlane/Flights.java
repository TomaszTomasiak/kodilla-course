package com.kodilla.good.patterns.airlane;

public class Flights {

    private String departurePort;
    private String destinationPort;
    private int flightNumber;

    public Flights(String departurePort, String destinationPort, int flightNumber) {
        this.departurePort = departurePort;
        this.destinationPort = destinationPort;
        this.flightNumber = flightNumber;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Numer lotu: " + flightNumber + ": " + departurePort +
                " -  " + destinationPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flights flights = (Flights) o;

        if (flightNumber != flights.flightNumber) return false;
        if (!departurePort.equals(flights.departurePort)) return false;
        return destinationPort.equals(flights.destinationPort);
    }

    @Override
    public int hashCode() {
        int result = departurePort.hashCode();
        result = 31 * result + destinationPort.hashCode();
        result = 31 * result + flightNumber;
        return result;
    }
}

