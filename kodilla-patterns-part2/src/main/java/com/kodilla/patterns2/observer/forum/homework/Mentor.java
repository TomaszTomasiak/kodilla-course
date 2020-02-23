package com.kodilla.patterns2.observer.forum.homework;

public class Mentor implements TaskObserver {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentTask studentTask) {
        System.out.println(mentorName + ": new task sent from " + studentTask.getStudent() + "\n" +
                "total: " + studentTask.getTasks().size() + " tasks waiting for check");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
