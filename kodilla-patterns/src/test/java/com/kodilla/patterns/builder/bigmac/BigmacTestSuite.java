package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient("Onion")
                .burgers(2)
                .ingredient("salad")
                .sauce("barbecue")
                .ingredient("cucumber")
                .ingredient("becon")
                .bun("with sesame seeds")
                .ingredient("cheese")
                .build();

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(5, howManyIngredients);
    }

}
