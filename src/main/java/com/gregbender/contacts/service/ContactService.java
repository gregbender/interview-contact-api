package com.gregbender.contacts.service;

import com.gregbender.contacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Contact> getAllContacts() {
        return mongoTemplate.findAll(Contact.class);
    }

    public void addContact(Contact newContact) {
        mongoTemplate.save(newContact);
    }

    public void updateContact(Contact updatedContact) {

    }

    public void deleteContact(String id) {
        Contact contactToDelete = mongoTemplate.findById(id, Contact.class);
        mongoTemplate.remove(contactToDelete);
    }

    public void deleteAll() {
        List<Contact> allContacts = mongoTemplate.findAll(Contact.class);
        for (Contact contact : allContacts) {
            mongoTemplate.remove(contact);
        }
    }
}
