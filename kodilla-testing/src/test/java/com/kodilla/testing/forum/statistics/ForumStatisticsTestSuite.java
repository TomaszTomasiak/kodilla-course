package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.ForumStatistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ForumStatisticsTestSuite {

    @Test
    public void testCalculateAdvStatisticsCondition0Users0Posts0Comments() {
        //Given
        Statistics statisticksMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();

        when(statisticksMock.usersNames()).thenReturn(new ArrayList<>());
        when(statisticksMock.postsCount()).thenReturn(0);
        when(statisticksMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticksMock);
        //Then
        assertEquals(0, forumStatistics.getNumberOfUsers());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost(), 0.1);
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
    }

    @Test
    public void testCalculateAdvStatisticsCondition100UsersAndMorePostsThanComments() {
        //Given
        Statistics statisticksMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticksMock.usersNames()).thenReturn(generatorNUsersNames(100));
        when(statisticksMock.postsCount()).thenReturn(1000);
        when(statisticksMock.commentsCount()).thenReturn(777);
        //When
        forumStatistics.calculateAdvStatistics(statisticksMock);
        double resultAverageNumberOfPostsPerUser = 1000 / 100;
        double resultAverageNumberOfCommentsPerPost = 777 / 1000;
        double resultAverageNumberOfCommentsPerUser = 777 / 100;

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(777, forumStatistics.getNumberOfComments());
        assertEquals(resultAverageNumberOfCommentsPerPost, forumStatistics.getAverageNumberOfCommentsPerPost(), 0.1);
        assertEquals(resultAverageNumberOfCommentsPerUser, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        assertEquals(resultAverageNumberOfPostsPerUser, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
    }

    @Test
    public void testCalculateAdvStatisticsCondition35UsersAndMoreCommentsThanPosts() {
        //Given
        Statistics statisticksMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticksMock.usersNames()).thenReturn(generatorNUsersNames(35));
        when(statisticksMock.postsCount()).thenReturn(500);
        when(statisticksMock.commentsCount()).thenReturn(1200);
        //When
        forumStatistics.calculateAdvStatistics(statisticksMock);

        double resultAverageNumberOfPostsPerUser = 500 / 35;
        double resultAverageNumberOfCommentsPerPost = 1200 / 500;
        double resultAverageNumberOfCommentsPerUser = 1200 / 35;

        //Then
        assertEquals(35, forumStatistics.getNumberOfUsers());
        assertEquals(500, forumStatistics.getNumberOfPosts());
        assertEquals(1200, forumStatistics.getNumberOfComments());
        assertEquals(resultAverageNumberOfCommentsPerPost, forumStatistics.getAverageNumberOfCommentsPerPost(), 0.1);
        assertEquals(resultAverageNumberOfCommentsPerUser, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        assertEquals(resultAverageNumberOfPostsPerUser, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
    }

    private ArrayList<String> generatorNUsersNames(int n) {
        ArrayList<String> resultNUsersNames = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String userName = "name" + (i);
            resultNUsersNames.add(userName);
        }
        return resultNUsersNames;
    }
}



