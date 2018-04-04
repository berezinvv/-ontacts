package com.contacts.json;

import com.contacts.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactJSON {

    private List<Contact> contacts = new ArrayList<>();

    public ContactJSON(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public ContactJSON() {
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
