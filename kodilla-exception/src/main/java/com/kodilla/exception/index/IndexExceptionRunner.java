package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        if (collection.size() > 2) {
            String anotherMovie = collection.get(2);
            System.out.println(anotherMovie);
        } else {
            System.out.println("The highest index is :" + (collection.size()-1));
            String movie = collection.get(0);
            System.out.println("The movie on the list on index 0 is :" + movie);
        }
    }
}
