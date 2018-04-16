package com.contacts.controller;

import com.contacts.entity.Contact;
import com.contacts.json.ContactJSON;
import com.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class WebController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/save")
    public ResponseEntity<String> save() {
        // save
        contactRepository.save(new Contact(1, "Jack"));
        contactRepository.save(new Contact(2, "Smith"));
        contactRepository.save(new Contact(3, "Adam"));
        contactRepository.save(new Contact(4, "Johnson"));
        contactRepository.save(new Contact(5, "Kim"));
        contactRepository.save(new Contact(6, "Smith"));
        contactRepository.save(new Contact(7, "David"));
        contactRepository.save(new Contact(8, "Williams"));
        contactRepository.save(new Contact(9, "Peter"));
        contactRepository.save(new Contact(10, "Davis"));

        return new ResponseEntity<String>("Done", HttpStatus.CREATED);
    }

    @RequestMapping("/contacts")
    public ResponseEntity<ContactJSON> findByNameFilter(@RequestParam("nameFilter") String nameFilter) {

        ContactJSON contactJSON = new ContactJSON();

        if (nameFilter.isEmpty()) {
            return new ResponseEntity<ContactJSON>(contactJSON, HttpStatus.BAD_REQUEST);
        }

        List<Contact> contactList = contactRepository.findByNameFilter(nameFilter);

        contactJSON.setContacts(contactList);

        return new ResponseEntity<ContactJSON>(contactJSON, HttpStatus.OK);
    }
}
