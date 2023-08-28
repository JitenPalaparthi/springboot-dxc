package io.akalabs.jpademo.repositories;

import io.akalabs.jpademo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    
}