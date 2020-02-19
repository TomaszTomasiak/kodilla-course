package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        System.out.println(" - - - - - -  - - - -  - - - - - - -");

        Calculator calculator = new Calculator();

        int addResult = calculator.add(25, 333);
        int subtructResult = calculator.subtract(121, 31);

        if ((addResult == 358) && (subtructResult == 90)) {
            System.out.println("Calculator test: OK");
        } else {
            System.out.println("Error!");
        }
    }
}