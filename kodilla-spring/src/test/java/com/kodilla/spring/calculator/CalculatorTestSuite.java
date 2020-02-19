package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void testAddCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(25.8, 73.6);

        //Then
        double addExpected = 25.8 + 73.6;

        Assert.assertEquals(addExpected, addResult, 0.1);
    }

    @Test
    public void testSubCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator)context.getBean("calculator");

        //When
        double subResult = calculator.sub(51.8, 9.2);

        //Then
        double subExpected = 51.8 - 9.2;

        Assert.assertEquals(subExpected, subResult, 0.1);
    }

    @Test
    public void testDivCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double divResult = calculator.div(784.82, 17.0);

        //Then
        double divExpected = 784.82 / 17.0;

        Assert.assertEquals(divExpected, divResult, 0.1);
    }

    @Test
    public void testMulCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator)context.getBean("calculator");

        //When
        double mulResult = calculator.mul(5.8, 23.3);

        //Then
        double mulExpected = 5.8 * 23.3;

        Assert.assertEquals(mulExpected, mulResult, 0.1);
    }
}
