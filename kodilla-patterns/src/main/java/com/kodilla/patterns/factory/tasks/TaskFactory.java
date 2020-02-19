package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Shape;

public class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Shopping",  "beer", 24);
            case PAINTINGTASK:
                return new PaintingTask("Painting", "blue", "sky");
            case DRIVINGTASK:
                return new DrivingTask("Driving", "to Los Angeles", "by car");
            default:
                return null;
        }
    }
}
