package com.kodilla.good.patterns.srp;

public class Application {

    public static void main(String[] args) {

        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentalRequest rentalRequest = rentRequestRetriever.retrieve();

        RentalProcessor rentalProcessor = new RentalProcessor(new InformationService(), new RentalService(), new RentalRepository());
        rentalProcessor.process(rentalRequest);
    }
}
