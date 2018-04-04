package com.contacts.controller;

import com.contacts.entity.Contact;
import com.contacts.json.ContactJSON;
import com.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hello")
public class WebController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/save")
    public  ResponseEntity<String> save() {
        // save a single Contact
        contactRepository.save(new Contact("Jack"));
        contactRepository.save(new Contact("Smith"));
        contactRepository.save(new Contact("Adam"));
        contactRepository.save(new Contact("Johnson"));
        contactRepository.save(new Contact("Kim"));
        contactRepository.save(new Contact("Smith"));
        contactRepository.save(new Contact("David"));
        contactRepository.save(new Contact("Williams"));
        contactRepository.save(new Contact("Peter"));
        contactRepository.save(new Contact("Davis"));

        return  new ResponseEntity<String>("Done", HttpStatus.CREATED);
    }

    @RequestMapping("/contacts")
    public ResponseEntity<ContactJSON> findByNameFilter(@RequestParam("nameFilter") String nameFilter) {

        ContactJSON contactJSON = new ContactJSON();

        if (nameFilter.isEmpty()){
            return new ResponseEntity<ContactJSON>(contactJSON, HttpStatus.BAD_REQUEST);
        }

        List<Contact> contactList = contactRepository.findAll();

        contactJSON.setContacts(contactList.stream().filter(contact -> !contact.getName().matches(nameFilter)).collect(Collectors.toList()));

        if (!nameFilter.isEmpty() && contactJSON.getContacts().size() == 0){
            return new ResponseEntity<ContactJSON>(contactJSON, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ContactJSON>(contactJSON, HttpStatus.OK);
    }
}
