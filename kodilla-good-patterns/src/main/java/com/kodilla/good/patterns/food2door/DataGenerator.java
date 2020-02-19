package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;

public class DataGenerator {

    LocalDate termOfDelivery = LocalDate.of(2019, 12, 31);

    SupplierOrderProcessor extraFoodShop = new ExtraFoodShop("Extra Food Shop", 4444);
    SupplierOrderProcessor healthyShop = new HealthyShop("Healthy Shop", 5555);
    SupplierOrderProcessor glutenFreeShop = new GlutenFreeShop("Gluten Free Shop", 1111);
    SupplierOrderProcessor newShop = new NewShop("New Shop", 9999);

    Product melon = new Product("Melon", 1234, 5.3, extraFoodShop);
    Product pasta = new Product("Gluten Free Pasta", 2222, 6.8, glutenFreeShop);
    Product toothPaste = new Product("ToothPaste", 3333, 10.25, healthyShop);
    Product toothPaste2 = new Product("ToothPaste", 3333, 10.25, newShop);

    public OrderRequest sampleOrder() {
        User user = new User("Batman", 1234);
        return new OrderRequest(user, toothPaste, 2, termOfDelivery);
    }
}
