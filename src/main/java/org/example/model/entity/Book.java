package org.example.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    @TextIndexed
    private String searchText; // full-text searching
    private List<String> categoryIds; // manual references

    // Constructors
    public Book() {}

    public Book(String title, String author, String description, List<String> categoryIds) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.categoryIds = categoryIds;
        // full-text search
        this.searchText = title + " " + author + " " + description;
    }

    // Setters and Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", categoryIds=" + categoryIds +
                '}';
    }
}
