package com.contacts;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ApplicationTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/hello";

//    @Test
//    public void testingStatusCode_Save201CREATED() throws IOException {

//        HttpUriRequest request = new HttpGet(REST_SERVICE_URI + "/save");
//
//        HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(request);
//
//        assertThat(httpResponse.getStatusLine().getStatusCode(),
//                equalTo(201));
//    }

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