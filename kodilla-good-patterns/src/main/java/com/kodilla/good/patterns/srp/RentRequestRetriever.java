package com.kodilla.good.patterns.srp;

import java.time.LocalDateTime;

public class RentRequestRetriever {

    public RentalRequest retrieve() {

        User user = new User ("John", "Black");

        LocalDateTime rentFrom = LocalDateTime.of(2017, 8, 1, 12, 0);
        LocalDateTime rentTo = LocalDateTime.of(2017, 8, 10, 12, 0);

        return new RentalRequest(user, rentFrom, rentTo);
    }
}
