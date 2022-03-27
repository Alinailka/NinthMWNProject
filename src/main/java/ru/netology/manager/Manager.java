package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class Manager {

    private Product[] products = new Product[0];

   private ProductRepository repository = new ProductRepository();

//    public Manager(ProductRepository repository) {
//        this.repository = repository;
//    }
//
//    public Manager(Product[] products) {
//        this.products = products;
//    }

    public void add(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }
public Product[] getAll() {
        Product [] result = new Product[products.length];
        for (int i=0; i < result.length; i++) {
            int index = products.length - i - 1;
            result[i] = products[index];
        }
        return result;
        }



        public Product[] searchBy(String text) {
            Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
            for (Product product : repository.findAll()) {
                if (matches(product, text)) {
                    // "добавляем в конец" массива result продукт product
                }
            }
            return result;
        }

        // метод определения соответствия товара product запросу search
        public boolean matches(Product product, String search) {
            if (product.getName().contains(search)) {
                return true;
            } else {
                return false;
            }
            // или в одну строку:
            // return product.getName().contains(search);
        }
    }



















