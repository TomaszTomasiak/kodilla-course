package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> figures = new ArrayList<>();
    private String shapeName;
    private double field;

    public ShapeCollector() {
    }

    public ArrayList<Shape> getShape() {
        return figures;
    }

    public Shape addFigure(Shape shape) {
        figures.add(shape);
        return shape;
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figures.contains(shape)){
            figures.remove(shape);
            result = true;
        }
        return true;
    }

    public Shape getFigure(int n) {
        Shape figure = figures.get(n);
        return figure;
    }

    public String showFigures(int n) {

        return getFigure(n).getShapeName();

    }
}
