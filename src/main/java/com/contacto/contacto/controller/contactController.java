package com.contacto.contacto.controller;

import com.contacto.contacto.model.ContactModel;
import com.contacto.contacto.service.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/contact")
public class contactController {

    private final ContactService contactService;

    public contactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/register")
    public ResponseEntity<ContactModel> register(@RequestBody ContactModel contact) {
        return ResponseEntity.ok(contactService.register(contact));
    }
    
    @PostMapping("/auth")
    public ResponseEntity<String> auth(@RequestParam String email, @RequestParam String password) {
        Optional<ContactModel> contact = contactService.findByEmail(email, password);
        return contact.isPresent() ? ResponseEntity.ok("Authorized") : ResponseEntity.status(401).body("Unauthorized");
    }
    
}
