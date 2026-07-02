package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("Dependency Injection Test:");
        System.out.println("--------------------------");
        bookService.printBook(1);
        bookService.printBook(2);
        bookService.printBook(3);
    }
}
