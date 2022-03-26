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
        assertArrayEquals(expected,actual);

//        ProductRepository repository = new ProductRepository();
//
//                Product first = new Book(1, "FairyTale", 10, "Pushkin");
//                Product second = new Book(2, "Stories", 12, "Chekhov");
//                Product third = new Smartphone(3, "NewModel", 100, "Apple");
//                Product fourth = new Smartphone(4, "OldModel", 70, "Peach");
//                repository.save(first);
//                repository.save(second);
//                repository.save(third);
//                repository.save(fourth);
//        ProductRepository[] actual = repository.save(1);
//        ProductRepository[] expected = {repository};
//            assertArrayEquals(expected,actual);
    }

    @Test
    void findAll() {repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void findById() {
    }

    @Test
    void removeById() {
    }
}