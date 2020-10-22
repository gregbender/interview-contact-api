package com.gregbender.contacts.controller;

import com.gregbender.contacts.entity.Contact;
import com.gregbender.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{id}")
    public List<Contact> getContactById(@PathVariable("id") int id) {
        return contactService.getAllContacts();
    }

    @PostMapping("/contact")
    public String addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
        return "{\"response\": \"ok\"}";
    }

    @PutMapping("/contact/{id}")
    public List<Contact> updateContact(@PathVariable("id") int id) {

        return contactService.getAllContacts();
    }

    @DeleteMapping("/contact/{id}")
    public String deleteContact(@PathVariable("id") String id) {
        System.out.println("trying to delete" + id);
        contactService.deleteContact(id);
        return "{status:done}";
    }

    @DeleteMapping("/contact/reset")
    public void reset() {
        contactService.deleteAll();
    }
}
