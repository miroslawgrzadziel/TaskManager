package taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
