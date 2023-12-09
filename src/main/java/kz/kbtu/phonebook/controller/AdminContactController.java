package kz.kbtu.phonebook.controller;

import kz.kbtu.phonebook.model.Contact;
import kz.kbtu.phonebook.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController

@RequestMapping("/admin")
public class AdminContactController {
    private final ContactRepository contactRepository;

    @GetMapping("/contacts")
    public Page<Contact> findAllContacts(Pageable pageable) {
        return this.contactRepository.findAll(pageable);
    }

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
        return this.contactRepository.save(contact);
    }


    @GetMapping("/contacts/number")
    public Page<Contact> findContactByPhoneNumber(@RequestParam(value = "phonenumber") String phoneNumber, Pageable pageable) {
        return this.contactRepository.findContactByPhoneNumber(phoneNumber, pageable);
    }

    @GetMapping("/contacts/username")
    public Page<Contact> findContactByUsername(@RequestParam(value = "username") String username, Pageable pageable) {
        return this.contactRepository.findContactByUserUsername(username, pageable);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable int id, @RequestBody Contact updatedContact) {
        Optional<Contact> existingContactOptional = contactRepository.findById(id);

        if (existingContactOptional.isPresent()) {
            Contact existingContact = existingContactOptional.get();

            existingContact.setAddress(updatedContact.getAddress());
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
            Contact savedContact = contactRepository.save(existingContact);

            return new ResponseEntity<>(savedContact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            contactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
