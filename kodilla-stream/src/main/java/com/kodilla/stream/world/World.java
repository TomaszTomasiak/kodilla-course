package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public final class World {

    private final Set<Continent> continentSet = new HashSet<>();

    public Set<Continent> getContinentSet() {
        return continentSet;
    }

    public void addContinent(Continent continent) {
        continentSet.add(continent);
    }


    public BigDecimal getPeopleQuantity() {

        return continentSet.stream()
                .flatMap(continent -> continent.getCountriesSet().stream())
                .map(c -> c.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

    }
}


