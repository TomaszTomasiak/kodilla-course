package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> numbers = new ArrayList<>();

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                evenList.add(numbers.get(i));
            }
        }
        return evenList;
    }
}
