package taskmanager.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import taskmanager.validator.groups.FullValidationUserGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="taskmanager_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(groups = {FullValidationUserGroup.class})
    @Column(length = 50)
    private String firstName;

    @NotEmpty(groups = {FullValidationUserGroup.class})
    @Column(length = 50)
    private String lastName;

    @Email
    @NotEmpty(groups = {Default.class, FullValidationUserGroup.class})
    private String email;

    @NotEmpty(groups = {FullValidationUserGroup.class})
    @Column(length = 100)
    private String position;

    @NotEmpty(groups = {Default.class, FullValidationUserGroup.class})
    private String password;

    @Transient
    private String passwordConfirm;

    @NotNull(groups = {FullValidationUserGroup.class})
    private Long rate;

    private boolean adminChck = false;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<TaskOperations> taskOperations = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public boolean isAdminChck() {
        return adminChck;
    }

    public void setAdminChck(boolean adminChck) {
        this.adminChck = adminChck;
    }

    public List<TaskOperations> getTaskOperations() {
        return taskOperations;
    }

    public void setTaskOperations(List<TaskOperations> taskOperations) {
        this.taskOperations = taskOperations;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
