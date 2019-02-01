package taskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import taskmanager.entity.TaskOperations;
import taskmanager.entity.User;
import taskmanager.repository.TaskOperationsRepository;

import javax.servlet.http.HttpSession;

@Service
public class TaskOperationsService {

    @Autowired
    private TaskOperationsRepository taskOperationsRepository;

    public void addTaskOperationsGet(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("taskOperations", new TaskOperations());
        model.addAttribute("user", user);
    }

    public void addTaskOperationsPost(TaskOperations taskOperations) {
        taskOperationsRepository.save(taskOperations);
    }

    public void editTaskOperations(Model model, Long id) {
        TaskOperations taskOperations = taskOperationsRepository.findOne(id);
        model.addAttribute("taskOperations", taskOperations);
    }

    public void deleteTaskOperations(Long id) {
        taskOperationsRepository.delete(id);
    }

    public void showAll(Model model) {
        model.addAttribute("tasksOperations", taskOperationsRepository.findAll());
    }
}

