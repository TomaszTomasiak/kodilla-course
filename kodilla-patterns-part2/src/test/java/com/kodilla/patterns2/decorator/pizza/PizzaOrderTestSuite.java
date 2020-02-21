package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testThickTomatoMozarellaHamMushroomPizza() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThickBasePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new TomatoSoucePizzaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);

        BigDecimal cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(25), cost);
        assertEquals("Pizza: thick base, tomato souce, mozarella, ham, mushrooms", description);
    }

    @Test
    public void testThinBarbecueMozzarellaPepperoniOlivesPizza() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThinBasePizzaDecorator(pizzaOrder);
        pizzaOrder = new BarbecueSoucePizzaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new PepperoniDecoraotor(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);

        BigDecimal cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(26), cost);
        assertEquals("Pizza: thin base, souce: barbecue, mozarella, pepperoni, olives", description);
    }
}
