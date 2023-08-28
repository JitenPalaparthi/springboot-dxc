package io.akalabs.jpademo.repositories;

import io.akalabs.jpademo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findByName(String name);
    List<Contact> findByEmail(String email);
}