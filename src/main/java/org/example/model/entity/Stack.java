package org.example.model.entity;

import com.mongodb.client.model.geojson.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "stacks")
public class Stack {
    @Id
    private String id;
    private int rows;
    private int columns;

    // пространственный индекс Geo JSON
    private Point location;

    // мануальные ссылки
    private List<String> bookIds;

    public Stack() {}

    public Stack(int rows, int columns, Point location) {
        this.rows = rows;
        this.columns = columns;
        this.location = location;
        this.bookIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public void addBookId(String bookId) {
        this.bookIds.add(bookId);
    }

    public void removeBookId(String bookId) {
        this.bookIds.remove(bookId);
    }

    public boolean containsBookId(String bookId) {
        return this.bookIds.contains(bookId);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "id='" + id + '\'' +
                ", rows=" + rows +
                ", columns=" + columns +
                ", location=" + location +
                ", bookIds=" + bookIds +
                '}';
    }
}

