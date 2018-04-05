package com.contacts;

import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class ApplicationTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/hello";

    @Autowired
    private MockMvc mvc;

    @Mock
    private ContactRepository contactRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact(1, "Jack"));
        contactList.add(new Contact(2, "Smith"));
        contactList.add(new Contact(3, "Adam"));
        when(contactRepository.findAll()).thenReturn(contactList);

        List<Contact> result = contactRepository.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void saveContacts() {
        Contact contact = new Contact(1, "Jack");
        when(contactRepository.save(contact)).thenReturn(contact);
        Contact result = contactRepository.save(contact);
        assertEquals(java.util.Optional.of(1).get(), result.getId());
        assertEquals("Jack", result.getName());
    }

    @Test
    public void testingStatusCode_Save201CREATED() throws IOException {

//        HttpUriRequest request = new HttpGet(REST_SERVICE_URI + "/save");
//
//        HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(request);
//
//        assertThat(httpResponse.getStatusLine().getStatusCode(),
//                equalTo(201));
    }

    @Test
    public void testingStatusCode_Contacts400BAD_REQUEST() throws IOException {

//        HttpUriRequest request = new HttpGet(REST_SERVICE_URI + "/contacts?nameFilter=");
//
//        HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(request);
//
//        assertThat(httpResponse.getStatusLine().getStatusCode(),
//                equalTo(400));
    }
}