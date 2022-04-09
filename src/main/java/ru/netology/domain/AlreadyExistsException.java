package ru.netology.domain;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Продукт с id " + id + " был добавлен ранее!");
    }
}
