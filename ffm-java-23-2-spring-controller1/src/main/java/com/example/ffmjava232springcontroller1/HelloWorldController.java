package com.example.ffmjava232springcontroller1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class HelloWorldController {

    private List<Message> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHalloWorld() {
        return "Hello World Ivan";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hallo " + name + "!";
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }
    @PostMapping("/messages")
    public String addMessage(@RequestBody Message message) {
        messages.add(message);
        // Process messages using forEach
        messages.forEach(msg -> {
            // Perform some operation on each message if needed
            // For example, print the details to the console
            System.out.println("ID: " + msg.getId() + ", Name: " + msg.getName() + ", Message: " + msg.getMessage());
        });

        return "Message added successfully!";
    }

}
