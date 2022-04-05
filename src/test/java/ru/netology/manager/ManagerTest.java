package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager manager = new Manager();

    Product first = new Book(1, "FairyTale", 10, "Pushkin");
    Product second = new Book(2, "Stories", 12, "Chekhov");
    Product third = new Smartphone(3, "NewModel", 100, "Apple");
    Product fourth = new Smartphone(4, "OldModel", 70, "Peach");
    Product fifth = new Book(5, "FairyTale", 15, "Ershov");
    Book one = new Book(6, "Olla", 10, "Sting");

    @BeforeEach
    void preAdd(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void add() {

        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Stories");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNoName() {

        Product[] actual = manager.searchBy("Cool");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

//    @Test
//    void searchByAuthorBook() {
//        manager.add(first);
//        manager.add(second);
//        manager.add(third);
//        manager.add(fourth);
//        manager.add(one);
//        Product[] actual = manager.searchBy("Sting");
//        Product[] expected = new Product[0];
//        assertArrayEquals(expected, actual);
//    }

    @Test
    void searchByNameIfSeveralSame() {

        manager.add(fifth);
        Product[] actual = manager.searchBy("FairyTale");
        Product[] expected = new Product[]{first, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void matchesTrue() {

        manager.searchBy("Stories");
        assertTrue(manager.matches(second, "Stories"));
    }

    @Test
    void matchesFalse() {

        manager.searchBy("Cool");
        assertFalse(manager.matches(second, "Cool"));
    }
}