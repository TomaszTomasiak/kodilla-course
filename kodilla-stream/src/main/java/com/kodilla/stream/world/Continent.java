package com.kodilla.stream.world;

import java.util.*;
import java.util.stream.Collectors;

public final class Continent {

    private final String continentName;
    private final Set<Country> countrySet = new HashSet<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public void addCountryToContinent (Country country){
        countrySet.add(country);
    }
    public String getContinentName() {
        return continentName;
    }

    public Set<Country> getCountriesSet() {
        return countrySet;
    }
}

