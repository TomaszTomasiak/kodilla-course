package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square("square", 10.7);

        //When
        shapeCollector.addFigure(square);
        Shape retrivedShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(square, retrivedShape);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square("square", 10.7);
        shapeCollector.addFigure(square);

        //When
        boolean result = shapeCollector.removeFigure(square);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testShowFigures() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        String expected = "square";
        Square square = new Square("square", 10.7);
        shapeCollector.addFigure(square) ;
        //When

        String showCheck = shapeCollector.showFigures(0);

        //Then
        Assert.assertEquals(expected, showCheck);
    }
}
