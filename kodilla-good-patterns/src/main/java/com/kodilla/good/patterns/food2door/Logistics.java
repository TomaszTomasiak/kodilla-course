package com.kodilla.good.patterns.food2door;

public class Logistics {


    public boolean checkStock(Product product, int quantity) {
        System.out.println("Produkt " + product + " jest dostępny");

        return true;
    }

    public void checkUser(User user) {
        System.out.println("Sprawdzam, czy użytkownik: " + user + " jest zarejestrowany w naszej bazie danych");

    }

}
