package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Board;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given

        Book book1 = new Book("Przemineło z wiatrem", "Mitchell Margaret", LocalDate.of(1936, 6, 30));
        Book book2 = new Book("Wiedźmin", "Andrzej Sapkowski", LocalDate.of(2007, 10, 26));
        Book book3 = new Book("Prawiek", "Olga Tokarczuk", LocalDate.of(1996, 1, 1));

        Library library = new Library("Biblioteka Uniwersytecka");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Biblioteka Publiczna");
        } catch (CloneNotSupportedException e) {
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Biblioteka Narodowa");
        } catch (CloneNotSupportedException e) {
        }

        //When
        library.getBooks().remove(book1);

        //Then
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());

    }
}
