package com.kodilla.stream.world;

import com.kodilla.stream.sand.Europe;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country countryPoland = new Country("Poland", "38000000");
        Country countryFrance = new Country("France", "68000000");
        Country countryGermany = new Country("Germany", "73000000");
        Country countryChina = new Country("China", "723000000");
        Country countryRusia = new Country("Russia", "234000000");
        Country countryJapan = new Country("Japan", "56000000");
        Country countryNewZeland = new Country("New Zeland", "15600000");
        Country countryAustralia = new Country("Australia", "23000000");

        Continent continentEurope = new Continent("Europe");
        continentEurope.addCountryToContinent(countryPoland);
        continentEurope.addCountryToContinent(countryGermany);
        continentEurope.addCountryToContinent(countryFrance);

        Continent continentAsia = new Continent("Asia");
        continentAsia.addCountryToContinent(countryChina);
        continentAsia.addCountryToContinent(countryRusia);
        continentAsia.addCountryToContinent(countryJapan);

        Continent continentAustralia = new Continent("Australia");
        continentAustralia.addCountryToContinent(countryAustralia);
        continentAustralia.addCountryToContinent(countryNewZeland);

        World world = new World();
        world.addContinent(continentEurope);
        world.addContinent(continentAsia);
        world.addContinent(continentAustralia);

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(countryFrance);
        countries.add(countryAustralia);
        countries.add(countryChina);
        countries.add(countryGermany);
        countries.add(countryJapan);
        countries.add(countryNewZeland);
        countries.add(countryPoland);
        countries.add(countryRusia);

        BigDecimal expectedNuberOfPeople = new BigDecimal("1230600000");

        //When

        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then

        Assert.assertEquals(expectedNuberOfPeople, totalPeopleQuantity);

    }
}
