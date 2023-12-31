package kz.kbtu.phonebook.service;
import kz.kbtu.phonebook.model.User;
import kz.kbtu.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private EventPublisher eventPublisher;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        eventPublisher.publishEvent("Created user: " + user.toString());
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            eventPublisher.publishEvent(("Updated user: " + updatedUser.toString()));
            return userRepository.save(updatedUser);
        }
        return null; // Or throw an exception indicating user not found
    }


    public void deleteUser(Long id) {
        eventPublisher.publishEvent("User deleted: " + userRepository.findById(id).toString());
        userRepository.deleteById(id);
    }
}
