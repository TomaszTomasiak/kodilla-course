package com.kodilla.stream.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        List<Integer> theNumbersList = new ArrayList<>();

       IntStream.range(0, numbers.length)
              .forEach(n->theNumbersList.add(numbers[n]));

        return IntStream.range(0, theNumbersList.size())
                .map(n -> theNumbersList.get(n))
                .average().getAsDouble();
    }
}
