package org.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.example.model.entity.Stack;

@Repository
public interface StackRepository extends MongoRepository<Stack, String > {
}
