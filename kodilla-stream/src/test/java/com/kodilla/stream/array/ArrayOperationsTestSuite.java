package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {

    @Test

    //Given
    public void testGetAverage() {

        int[] getNumbers = new int[20];

        for (int i = 0; i < getNumbers.length; i++) {
            Random random = new Random();
            int x = random.nextInt();
            getNumbers[i] = x;
        }

            OptionalDouble tmpAverageExpected;
            tmpAverageExpected = IntStream.range(0, getNumbers.length)
                    .map(n -> getNumbers[n])
                    .average();
            double averageExpected = tmpAverageExpected.getAsDouble();

            //When
            double averageCheck = ArrayOperations.getAverage(getNumbers);

            //Then
            Assert.assertEquals(averageExpected, averageCheck, 0.01);

    }
}
