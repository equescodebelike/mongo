package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/books")
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Read
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void clearDatabase() {
        bookRepository.deleteAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return bookRepository.findById(id);
    }

//    public List<Book> getBooksByTitle(String title) {
//        return bookRepository.findByTitle(title);
//    }

    // Update
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        // Update book details with those from bookDetails
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setDescription(updatedBook.getDescription());
        book.setCategoryIds(updatedBook.getCategoryIds());
        return bookRepository.save(book);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }


    public void populateBooks() {
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Book book = new Book();
            book.setTitle("Book " + i);
            book.setAuthor("Author " + i);
            book.setDescription("Description for Book " + i);
            books.add(book);
        }

        bookRepository.saveAll(books);
    }
}
