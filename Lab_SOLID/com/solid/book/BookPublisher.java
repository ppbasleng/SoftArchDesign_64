package com.solid.book;


import java.util.List;

public interface BookPublisher {
    public void printToFile();

    public static void main(String[] args) {
        BookPublisher book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too!"));
        book.printToFile();
    }
}
