package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public final class TaskLst {
    final private String name;
    final private List<Task> tasks = new ArrayList<>();

    public TaskLst(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        String s = "     List [" + name + "]";
        for (Task task : tasks) {
            s = s + "\n" + task.toString();
        }
        return s;
    }
}
