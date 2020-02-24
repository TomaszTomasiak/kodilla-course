package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<BookA> bookASet = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        bookASet.add(new BookA("Dylan Murphy", "Wolf of the mountain",
                2003, "0001"));
        bookASet.add(new BookA("Phoebe Pearson", "Slaves of dreams",
                2012, "0002"));
        bookASet.add(new BookA("Morgan Walsh", "Obliteration of heaven",
                2001, "0003"));
        bookASet.add(new BookA("Aimee Murphy", "Rejecting the night",
                2015, "0004"));
        bookASet.add(new BookA("Ryan Talley", "Gangsters and kings",
                2007, "0005"));
        bookASet.add(new BookA("Madelynn Carson", "Unity without duty",
                2007, "0006"));
        bookASet.add(new BookA("Giancarlo Guerrero", "Enemies of eternity",
                2009, "0007"));

        //When
        int medianResult = medianAdapter.poblicationYearMedian(bookASet);

        //Then
        assertEquals(2007, medianResult);
    }
}
