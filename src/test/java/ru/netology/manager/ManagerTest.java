package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager manager = new Manager();

    @Test
    void add() {
        ProductRepository repo = new ProductRepository();
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.add(fourth);
        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchByName() {
        ProductRepository repository = new ProductRepository();
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Stories");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNoName() {

        String searchByName = "Cool";
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        manager.searchBy("Cool");
        Product[] actual = manager.searchBy("Cool");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void matchesTrue() {

        String searchByName = "Stories";
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.add(fourth);
        manager.searchBy("Stories");
        boolean expected = true;
        boolean actual = manager.matches(second, "Stories");
        assertEquals(expected, actual);
    }

    @Test
    void matchesFalse() {

        String searchByName = "Cool";
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.add(fourth);
        manager.searchBy("Cool");
        boolean expected = false;
        boolean actual = manager.matches(second, "Cool");
        assertEquals(expected, actual);
    }
}