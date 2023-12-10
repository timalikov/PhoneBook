package kz.kbtu.phonebook.service;


import kz.kbtu.phonebook.model.Contact;
import kz.kbtu.phonebook.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactService {
    public final ContactRepository contactRepository;

    public Page<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }
    public Page<Contact> findContactByPhoneNumber(String phoneNumber, Pageable pageable) {
        return contactRepository.findContactByPhoneNumber(phoneNumber, pageable);
    }

    public Page<Contact> findContactByUsername(String username, Pageable pageable) {
        return contactRepository.findContactByUserUsername(username, pageable);
    }
}

