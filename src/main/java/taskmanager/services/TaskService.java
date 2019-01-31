package taskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import taskmanager.entity.Task;
import taskmanager.entity.User;
import taskmanager.repository.TaskRepository;

import javax.servlet.http.HttpSession;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    public void addTaskGet(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("task", new Task());
        model.addAttribute("user", user);
    }

    public void addTaskPost(Task task) {
        taskRepository.save(task);
    }

    public void editTask(Model model, Long id) {
        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);
    }

    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }

//    public void showTask(Long id, Model model, HttpServletRequest request) {
//        Task task = taskRepository.findOne(id);
//        model.addAttribute("task", task);
//        model.addAttribute("comment", new Comment());
//        model.addAttribute("user", request.getParameter("user"));
//    }

    public void showAll(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
    }
}
