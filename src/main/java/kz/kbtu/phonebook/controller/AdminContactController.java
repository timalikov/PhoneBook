package kz.kbtu.phonebook.controller;

import kz.kbtu.phonebook.model.Contact;
import kz.kbtu.phonebook.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController

@RequestMapping("/admin")
public class AdminContactController {
    private final ContactRepository contactRepository;

    @GetMapping("/contacts")
    public Iterable<Contact> findAllContacts() {
        return this.contactRepository.findAll();
    }

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
        return this.contactRepository.save(contact);
    }

//    @PutMapping("/contacts")
//    public Contact updateContact(@RequestParam(value = "id") @RequestBody Contact contact) {
//        return this.contactRepository.save(contact);
//    }

    @GetMapping("/contacts/number")
    public Page<Contact> findContactByPhoneNumber(@RequestParam(value = "phonenumber") String phoneNumber, Pageable pageable) {
        return this.contactRepository.findContactByPhoneNumber(phoneNumber, pageable);
    }

    @GetMapping("/contacts/username")
    public Page<Contact> findContactByUsername(@RequestParam(value = "username") String username, Pageable pageable) {
        return this.contactRepository.findContactByUserUsername(username, pageable);
    }

}
