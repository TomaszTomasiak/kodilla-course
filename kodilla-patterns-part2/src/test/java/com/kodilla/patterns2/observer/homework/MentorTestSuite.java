package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testUpdate() {

        //Given
        StudentTask rambo = new Rambo();
        StudentTask batman = new Batman();
        StudentTask alf = new Alf();
        StudentTask spiderman = new Spiderman();
        Task abstractClassTask = new Task("Abstract class task");
        Task springTask = new Task("Spring task");
        Task  arrayDequeTask= new Task("ArreyDeque task");
        Task hashMapTask = new Task("HashMap task");
        Mentor billGates = new Mentor("Bill Gates");
        Mentor markZuckerberg = new Mentor("Mark Zuckerberg");
        rambo.registerObserver(billGates);
        batman.registerObserver(billGates);
        alf.registerObserver(billGates);
        spiderman.registerObserver(markZuckerberg);

        //When
        rambo.sendTaskToCheck(abstractClassTask);
        rambo.sendTaskToCheck(hashMapTask);
        rambo.sendTaskToCheck(arrayDequeTask);
        alf.sendTaskToCheck(springTask);
        spiderman.sendTaskToCheck(hashMapTask);
        spiderman.sendTaskToCheck(arrayDequeTask);
        batman.sendTaskToCheck(arrayDequeTask);
        batman.sendTaskToCheck(arrayDequeTask);
        alf.sendTaskToCheck(hashMapTask);
        rambo.sendTaskToCheck(springTask);

        //Then
        assertEquals(8, billGates.getUpdateCount());
        assertEquals(2, markZuckerberg.getUpdateCount());

    }
}
