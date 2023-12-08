package kz.kbtu.phonebook.controller;
import kz.kbtu.phonebook.model.Contact;
import kz.kbtu.phonebook.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserContactController {
    private final ContactService contactService;

    @GetMapping("/contacts")
    public Page<Contact> findAllContacts(Pageable pageable) {
        return this.contactService.findAll(pageable);
    }

    @GetMapping("/contacts/number")
    public Page<Contact> findContactByPhoneNumber(@RequestParam(value = "phonenumber") String phoneNumber, Pageable pageable) {
        return this.contactService.findContactByPhoneNumber(phoneNumber, pageable);
    }

    @GetMapping("/contacts/username")
    public Page<Contact> findContactByUsername(@RequestParam(value = "username") String username, Pageable pageable) {
        return this.contactService.findContactByUsername(username, pageable);
    }

}
