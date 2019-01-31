package taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.entity.User;

public interface TaskOperationsRepository extends JpaRepository<User, Long> {
}
