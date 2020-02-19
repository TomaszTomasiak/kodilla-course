package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User john = new Millenials("John Rambo");
        User muminek = new YGeneration("Muminek");
        User claus = new ZGeneration("Santa Claus");

        //When
        String johnShouldPublish = john.sharePost();
        String muminekShouldPublish = muminek.sharePost();
        String clausShouldPublish = claus.sharePost();

        //Then
        Assert.assertEquals("Opublikowano post na Facebook-u", johnShouldPublish);
        Assert.assertEquals("Twitter - dodano tweet", muminekShouldPublish);
        Assert.assertEquals("Snapchat - poszło", clausShouldPublish);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User claus = new ZGeneration("Santa Claus");

        //When
        String clausShouldPublish = claus.sharePost();

        claus.setSocialPublisher(new TwitterPublisher());
        clausShouldPublish = claus.sharePost();

        //Then
        Assert.assertEquals("Twitter - dodano tweet", clausShouldPublish);
    }

}
