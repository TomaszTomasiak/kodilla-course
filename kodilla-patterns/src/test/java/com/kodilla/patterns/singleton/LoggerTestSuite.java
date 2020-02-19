package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void addToLog() {
        Logger.getInstance().log("Luke Skywalker");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String lastLogResult = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("Luke Skywalker", lastLogResult);
    }
}
