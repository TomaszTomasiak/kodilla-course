package com.kodilla.patterns.prototype.library;

public class Prototype<T> implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
