package taskmanager.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="taskmanager_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String subject;

    @CreationTimestamp
    private LocalDateTime dateReceived;

    @NotEmpty
    private String cilent;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private List<TaskOperations> taskOperations = new ArrayList<>();

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDateTime dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getCilent() {
        return cilent;
    }

    public void setCilent(String cilent) {
        this.cilent = cilent;
    }

    public List<TaskOperations> getTaskOperations() {
        return taskOperations;
    }

    public void setTaskOperations(List<TaskOperations> taskOperations) {
        this.taskOperations = taskOperations;
    }

    @Override
    public String toString() {
        return getSubject() + " " + getCilent();
    }
}
