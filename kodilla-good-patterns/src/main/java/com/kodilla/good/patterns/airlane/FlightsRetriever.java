package com.kodilla.good.patterns.airlane;

public class FlightsRetriever {

    public static FlightGenerator retrieve() {

        Flights flight1 = new Flights("Warszawa", "Poznań", 5487);
        Flights flight2 = new Flights("Warszawa", "Wrocław", 1212);
        Flights flight3 = new Flights("Warszawa", "Gdańsk", 6391);
        Flights flight4 = new Flights("Warszawa", "Kraków", 2254);
        Flights flight5 = new Flights("Warszawa", "Szczecin", 1963);
        Flights flight6 = new Flights("Poznań", "Warszawa", 2158);
        Flights flight7 = new Flights("Poznań", "Kraków", 3334);
        Flights flight8 = new Flights("Poznań", "Gdańsk", 6555);
        Flights flight9 = new Flights("Wrocław", "Gdańsk", 1254);
        Flights flight10 = new Flights("Wrocław", "Warszawa", 1288);
        Flights flight11 = new Flights("Wrocław", "Kraków", 4411);
        Flights flight12 = new Flights("Szczecin", "Warszawa", 2158);
        Flights flight13 = new Flights("Szczecin", "Kraków", 3334);
        Flights flight14 = new Flights("Szczecin", "Gdańsk", 6555);
        Flights flight15 = new Flights("Gdańsk", "Warszawa", 2158);
        Flights flight16 = new Flights("Gdańsk", "Kraków", 3334);
        Flights flight17 = new Flights("Gdańsk", "Poznań", 6555);
        Flights flight18 = new Flights("Gdańsk", "Warszawa", 8888);
        Flights flight19 = new Flights("Gdańsk", "Kraków", 9631);
        Flights flight20 = new Flights("Kraków", "Gdańsk", 7741);

        FlightGenerator flightGenerator = new FlightGenerator();
        flightGenerator.addLine(flight1);
        flightGenerator.addLine(flight2);
        flightGenerator.addLine(flight3);
        flightGenerator.addLine(flight4);
        flightGenerator.addLine(flight5);
        flightGenerator.addLine(flight6);
        flightGenerator.addLine(flight7);
        flightGenerator.addLine(flight8);
        flightGenerator.addLine(flight9);
        flightGenerator.addLine(flight10);
        flightGenerator.addLine(flight11);
        flightGenerator.addLine(flight12);
        flightGenerator.addLine(flight13);
        flightGenerator.addLine(flight14);
        flightGenerator.addLine(flight15);
        flightGenerator.addLine(flight16);
        flightGenerator.addLine(flight17);
        flightGenerator.addLine(flight18);
        flightGenerator.addLine(flight19);
        flightGenerator.addLine(flight20);

        return flightGenerator;
    }
}
