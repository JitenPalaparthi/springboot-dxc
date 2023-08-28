package io.akalabs.jpademo.controllers;

import io.akalabs.jpademo.models.Contact;
import io.akalabs.jpademo.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
 
    @Autowired
    ContactRepository contactRepository;

    @PostMapping("/contact")
    public Contact addContact(@RequestBody Contact contact){

        //1- It is a request body
        //2- make sure that the request body is in the form of json.
        //3- That means Content-Type: application/json
        //4- There should be a decoder that decodes the json data and put it in Contact Object
        // That contact object is used to call Save method, that gets saved in the database.
        // Return the contact Object after a successful save, along with ID
        //5- Response, which is in the form of Json
        //6- ensure json reponse headers and json response data

        // contact.setStatus("active");
        
      return contactRepository.save(contact);
         
    }
}
