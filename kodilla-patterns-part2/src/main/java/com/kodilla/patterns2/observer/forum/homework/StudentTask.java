package com.kodilla.patterns2.observer.forum.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StudentTask implements TaskObservable {
    private final List<TaskObserver> taskObservers;
    private final Queue<Task> tasks;
    private final String student;

    public StudentTask(String student) {
        this.student = student;
        taskObservers = new ArrayList<>();
        tasks = new ArrayDeque<>();
    }

    public String getStudent() {
        return student;
    }

    public void sendTaskToCheck(Task task) {
        tasks.offer(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(TaskObserver taskObserver) {
        taskObservers.add(taskObserver);
    }

    @Override
    public void notifyObservers() {
        for (TaskObserver taskObserver : taskObservers) {
            taskObserver.update(this);
        }
    }

    @Override
    public void removeObserver(TaskObserver taskObserver) {
        taskObservers.remove(taskObserver);
    }

    public Queue<Task> getTasks() {
        return tasks;
    }
}
