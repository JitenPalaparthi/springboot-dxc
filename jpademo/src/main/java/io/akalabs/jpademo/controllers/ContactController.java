package io.akalabs.jpademo.controllers;

import io.akalabs.jpademo.models.Contact;
import io.akalabs.jpademo.repositories.ContactRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

         contact.setStatus("active");
        // long tmeinMilli = Instant.now().toEpochMilli();
         contact.setLastModified(Instant.now().toEpochMilli());
         //Long lngtme= (Long)tmeinMilli;
        
      return contactRepository.save(contact);
         
    }

    @GetMapping("/contact/{id}")
    public Optional<Contact> geContactById(@PathVariable("id") Long id){
        return contactRepository.findById(id);
    }

    @GetMapping("/contact/byName/{name}")
    public List<Contact> getContactsByName(@PathVariable("name") String name){
        return contactRepository.findByName(name);
       // return contactRepository.findAll(null, null);
    }
    @GetMapping("/contact/byEmail/{email}")
    public List<Contact> getContactsByEmail(@PathVariable("email") String email){
        return contactRepository.findByEmail(email);
       // return contactRepository.findAll(null, null);
    }

    
}
