package com.library;

public class BookRepository {

    public String getBookById(int id) {
        if (id == 1) {
            return "Clean Code by Robert C. Martin";
        } else if (id == 2) {
            return "The Pragmatic Programmer by Andrew Hunt";
        } else {
            return "Book not found";
        }
    }
}
