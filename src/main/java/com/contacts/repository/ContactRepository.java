package com.contacts.repository;


import com.contacts.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM contacts c WHERE c.name !~ :nameFilter")
    List<Contact> findByNameFilter(@Param("nameFilter") String nameFilter);
}
