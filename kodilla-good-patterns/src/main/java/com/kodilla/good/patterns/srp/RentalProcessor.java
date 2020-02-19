package com.kodilla.good.patterns.srp;

public class RentalProcessor {

    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public RentalProcessor(final InformationService informationService, final RentalService rentalService, final RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process (final RentalRequest rentalRequest) {
        boolean isRented = rentalService.rent(rentalRequest.getUser(), rentalRequest.getFrom(), rentalRequest.getTo());

        if (isRented) {
            informationService.inform(rentalRequest.getUser());
            rentalRepository.createRental(rentalRequest.getUser(), rentalRequest.getFrom(), rentalRequest.getTo());
            return  new RentalDto(rentalRequest.getUser(), true);

        } else {
            return new RentalDto(rentalRequest.getUser(), true);
        }

    }
}
