package com.solid.book;


import java.util.List;

public interface BookReader {

    public void printToScreen();
    public static void main(String[] args) {
        BookReader book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        book.printToScreen();
    }
}
