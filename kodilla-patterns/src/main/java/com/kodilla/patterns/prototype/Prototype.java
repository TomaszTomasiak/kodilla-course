package com.kodilla.patterns.prototype;

public class Prototype<T> implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
