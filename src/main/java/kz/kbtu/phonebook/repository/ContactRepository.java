package kz.kbtu.phonebook.repository;

import kz.kbtu.phonebook.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface ContactRepository extends CrudRepository<Contact, Integer> {
//    List<Contact> findByPublished(boolean published);
//
//    List<Void> findByNumber(String number);
    Page<Contact> findAll(Pageable pageable);
    Contact save(Contact contact);
//    Contact getContactByUsername(String username);
    Page<Contact> findContactByPhoneNumber(String phoneNumber, Pageable pageable);
    Page<Contact> findContactByUserUsername(String username, Pageable pageable);

}