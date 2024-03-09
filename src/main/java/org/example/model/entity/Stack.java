package org.example.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "stacks")
public class Stack {
    @Id
    private String id;
    private String location;
    private int rows;
    private int columns;

    // пространственный индекс Geo JSON
    private String[][] shelves; // 2D array representing shelves

    // мануальные ссылки
    @DBRef
    private List<Book> books; // List of books in the stack

    // Constructors
    public Stack() {}

    public Stack(String location, int rows, int columns) {
        this.location = location;
        this.rows = rows;
        this.columns = columns;
        this.shelves = new String[rows][columns];
    }

    // Setters and Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String[][] getShelves() {
        return shelves;
    }

    public void setShelves(String[][] shelves) {
        this.shelves = shelves;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
