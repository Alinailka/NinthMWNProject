package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    Product first = new Book(1, "FairyTale", 10, "Pushkin");
    Product second = new Book(2, "Stories", 12, "Chekhov");
    Product third = new Smartphone(3, "NewModel", 100, "Apple");
    Product fourth = new Smartphone(4, "OldModel", 70, "Peach");

    @Test
    public void removeByIdWithNFE() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(3);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void notRemoveByIdWithNFE() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });
    }

    @Test
    public void saveOneItemWithAEE() {
        repository.save(first);
        repository.save(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveOneItemIfAlreadyWithAEE() {
        repository.save(first);
        repository.save(second);

        assertThrows(AlreadyExistsException.class, () -> {
            repository.save(first);
        });
    }

    @Test
    public void saveOneItem() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Product actual = repository.findById(2);
        Product expected = second;
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdNull() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

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

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(3);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, fourth};
        assertArrayEquals(expected, actual);
    }
}