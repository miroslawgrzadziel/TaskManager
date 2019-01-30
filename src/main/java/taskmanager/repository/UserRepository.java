package taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByLastName(String lastName);
}
