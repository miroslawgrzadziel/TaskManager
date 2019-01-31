package taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.entity.TaskOperations;

public interface TaskOperationsRepository extends JpaRepository<TaskOperations, Long> {
}
