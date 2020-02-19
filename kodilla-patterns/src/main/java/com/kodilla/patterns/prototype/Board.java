package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

public final class Board extends Prototype {
    private String name;
    private Set<TaskLst> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TaskLst> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TaskLst list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board) super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board) super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TaskLst theList : lists) {
            TaskLst clonedList = new TaskLst(theList.getName());
            for (Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}
