package com.gregbender.contacts.repository;

import com.gregbender.contacts.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
