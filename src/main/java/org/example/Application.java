package org.example;

import org.example.model.entity.Book;
import org.example.model.entity.Category;
import org.example.model.entity.Stack;
import org.example.service.BookService;
import org.example.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        BookService bookService = context.getBean(BookService.class);

//        bookService.clearDatabase();
        Category category = new Category("Category");
        category.setId("1");
        Book book = new Book("Title", "Author", "Description", List.of(category));
        book.setId("1");
        Book bookUpdated = new Book("Title2", "Author2", "Description2", List.of(category));
        bookUpdated.setId("2");
        bookService.createBook(book);
        bookService.createBook(bookUpdated);
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("All Books:");
        allBooks.forEach(System.out::println);
        bookService.updateBook("1",bookUpdated);
        bookService.deleteBook("2");
        System.out.println("All Books:");
        allBooks.forEach(System.out::println);
//        bookService.populateBooks();
    }
}
