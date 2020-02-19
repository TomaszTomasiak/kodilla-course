package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPINGTASK);
        boolean isTaskExecutedResultBeforeExecuteTask = shopping.isTaskExecuted();
        shopping.executeTask();
        boolean isTaskExecutedResultAfterExecuteTask = shopping.isTaskExecuted();
        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertFalse(isTaskExecutedResultBeforeExecuteTask);
        Assert.assertTrue(isTaskExecutedResultAfterExecuteTask);
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTINGTASK);
        boolean isTaskExecutedResultBeforeExecuteTask = painting.isTaskExecuted();
        painting.executeTask();
        boolean isTaskExecutedResultAfterExecuteTask = painting.isTaskExecuted();

        //Then
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertFalse(isTaskExecutedResultBeforeExecuteTask);
        Assert.assertTrue(isTaskExecutedResultAfterExecuteTask);
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVINGTASK);
        boolean isTaskExecutedResultBeforeExecuteTask = driving.isTaskExecuted();
        driving.executeTask();
        boolean isTaskExecutedResultAfterExecuteTask = driving.isTaskExecuted();
        //Then
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertFalse(isTaskExecutedResultBeforeExecuteTask);
        Assert.assertTrue(isTaskExecutedResultAfterExecuteTask);
    }

    @Test
    public void testFactoryNullTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task doNothing = factory.makeTask("null");
        //Then
        Assert.assertNull(doNothing);
    }
}
