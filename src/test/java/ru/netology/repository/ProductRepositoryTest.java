package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    @Test
    public void saveOneItem() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        ProductRepository repository = new ProductRepository();
        int idToFind = 2;
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.findById(idToFind);

        Product actual = repository.findById(2);
        Product expected = second;
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdNull() {
        ProductRepository repository = new ProductRepository();
        int idToFind = 5;
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.findById(idToFind);

        Product actual = repository.findById(5);
        Product expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        ProductRepository repository = new ProductRepository();
        int idToRemove = 3;
        Product first = new Book(1, "FairyTale", 10, "Pushkin");
        Product second = new Book(2, "Stories", 12, "Chekhov");
        Product third = new Smartphone(3, "NewModel", 100, "Apple");
        Product fourth = new Smartphone(4, "OldModel", 70, "Peach");
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(idToRemove);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, fourth};
        assertArrayEquals(expected, actual);
    }
}