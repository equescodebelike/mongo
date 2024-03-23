package org.example.service;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.example.model.entity.Stack;
import org.example.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stacks")
public class StackService {

    @Autowired
    private final StackRepository stackRepository;

    @Autowired
    public StackService(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    // Create
    @PostMapping
    public Stack createStack(@RequestBody Stack stack) {
        return stackRepository.save(stack);
    }

    // Read
    @GetMapping
    public List<Stack> getAllStacks() {
        return stackRepository.findAll();
    }

    public void clearDatabase() {
        stackRepository.deleteAll();
    }

    @GetMapping("/{id}")
    public Optional<Stack> getStackById(@PathVariable String id) {
        return stackRepository.findById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Stack updateStack(@PathVariable String id, @RequestBody Stack updatedStack) {
        Stack stack = stackRepository.findById(id).orElseThrow(() -> new RuntimeException("Stack not found"));
        stack.setLocation(updatedStack.getLocation());
        stack.setRows(updatedStack.getRows());
        stack.setColumns(updatedStack.getColumns());
        stack.setLocation(updatedStack.getLocation());
        return stackRepository.save(stack);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteStack(String id) {
        stackRepository.deleteById(id);
    }

    public void populateStacks() {
        List<Stack> stacks = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Stack stack = new Stack();
            stack.setRows(i);
            stack.setColumns(i);
            stack.setLocation(new Point(new Position(1 + i,2 + i)));
            stacks.add(stack);
        }

        stackRepository.saveAll(stacks);
    }
}
