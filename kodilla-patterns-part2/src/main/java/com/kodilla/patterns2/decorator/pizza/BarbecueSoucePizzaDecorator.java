package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BarbecueSoucePizzaDecorator extends AbstractPizzaOrderDecorator {

    protected BarbecueSoucePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", souce: barbecue";
    }

}
