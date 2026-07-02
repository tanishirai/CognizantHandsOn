package com.library;

public class BookService {

    private BookRepository bookRepository;

    // Spring will call this setter to inject BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBook(int id) {
        String book = bookRepository.getBookById(id);
        System.out.println("Book found: " + book);
    }
}
