package com.kodilla.patterns2.observer.forum.homework;

public interface TaskObservable {
    void registerObserver(TaskObserver taskObserver);
    void notifyObservers();
    void removeObserver(TaskObserver taskObserver);
}
