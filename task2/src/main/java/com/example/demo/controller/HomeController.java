package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Controller
public class HomeController {
    private final ContactRepository contactRepository;

    public HomeController(ContactRepository contactRepository) 
    {
    this.contactRepository = contactRepository;
    }

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

        Contact contact = new Contact();

        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);

        contactRepository.save(contact);
        
        return "index";
    }
}