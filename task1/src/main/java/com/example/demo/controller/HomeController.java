package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {

        return "index";
    }

    @PostMapping("/contact")
public String handleContact(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String message) {

    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println("Message: " + message);
    
    return "index";
}
}