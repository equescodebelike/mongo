package org.example.repository;

import org.bson.types.ObjectId;
import org.example.model.entity.Book;
import org.example.model.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
