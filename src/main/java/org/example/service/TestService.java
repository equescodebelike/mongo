package org.example.service;

import org.example.model.entity.Inventory;
import org.example.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    //@Autowired
    //private MongoTemplate customMongoTemplate;

    @Autowired
    private InventoryRepository inventoryRepository;

    public void testFind() {
        Set<String> names = mongoTemplate.getCollectionNames();
        names.forEach(x -> System.out.println(x));
    }

    public void testFindCustom() {
        //Set<String> names = customMongoTemplate.getCollectionNames();
        //names.forEach(x -> System.out.println(x));
    }

    public void testFindInventoryWithTemplate() {
        List<Inventory> inventories = mongoTemplate.findAll(Inventory.class);
        inventories.forEach(x -> {
            System.out.println(x);
        });
    }

    public void testFindInventoryWithRepository() {
        List<Inventory> inventories = inventoryRepository.findAll();
        inventories.forEach(x -> {
            System.out.println(x);
        });
    }
}
