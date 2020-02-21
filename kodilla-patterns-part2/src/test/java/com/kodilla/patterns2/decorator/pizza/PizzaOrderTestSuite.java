package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testThickTomatoMozarellaHamMushroomPizzaCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThickBasePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new TomatoSoucePizzaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(25), cost);
    }

    @Test
    public void testThickTomatoMozarellaHamMushroomPizzaDescripton() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThickBasePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new TomatoSoucePizzaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza: thick base, tomato souce, mozarella, ham, mushrooms", description);
    }
    @Test
    public void testThinBarbecueMozzarellaPepperoniOlivesPizzaCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThinBasePizzaDecorator(pizzaOrder);
        pizzaOrder = new BarbecueSoucePizzaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new PepperoniDecoraotor(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(26), cost);
    }

    @Test
    public void testThinBarbecueMozzarellaPepperoniOlivesPizzaDescripton() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ThinBasePizzaDecorator(pizzaOrder);
        pizzaOrder = new BarbecueSoucePizzaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new PepperoniDecoraotor(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza: thin base, souce: barbecue, mozarella, pepperoni, olives", description);
    }
}
