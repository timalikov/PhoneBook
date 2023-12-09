package kz.kbtu.phonebook.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import kz.kbtu.phonebook.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
