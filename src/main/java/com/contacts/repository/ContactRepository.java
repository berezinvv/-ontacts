package com.contacts.repository;

import com.contacts.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository  extends CrudRepository<Contact, Integer> {

    List<Contact> findByName(String lastName);
    List<Contact> findAll();
}
