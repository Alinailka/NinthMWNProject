package ru.netology.domain;

public class ProductRepository {
    private Product[] items = new Product[0];

    //метод умеет сохранять продукт
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //умеет возвращать все продукты
    public Product[] findAll() {
        return items;
    }

    //умеет находить продукт по id
    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // умеет удалять по id
    public Product removeById(int id) {
        int lenght = items.length - 1;
        Product[] tmp = new Product[lenght];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return null;}

}


