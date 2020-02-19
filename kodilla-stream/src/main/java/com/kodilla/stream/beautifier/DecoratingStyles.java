package com.kodilla.stream.beautifier;

import java.util.ArrayList;

public class DecoratingStyles {

    public static String hiddenLettersOfText(String text){
        String result = "";
        String symbol = "* ";

        for (int i = 0; i<text.length(); i++){
            result = symbol + result;
        }
        return result;
    }

    public static String letterSpacing(String text){
        String leterWithSpace = "";
        String result = "";

        for (int i = 0; i<(text.length()); i++){
            char letter = text.charAt(i);
            leterWithSpace = letter + " ";
            result = result + leterWithSpace;
        }
        return result;
    }
}
