package taskmanager.controller;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import taskmanager.entity.Task;
import taskmanager.entity.TaskOperations;
import taskmanager.entity.User;
import taskmanager.repository.TaskOperationsRepository;
import taskmanager.repository.TaskRepository;
import taskmanager.repository.UserRepository;
import taskmanager.services.TaskOperationsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/taskoperations")
public class TaskOperationsController {

    @Autowired
    private TaskOperationsRepository taskOperationsRepository;

    @Autowired
    private TaskOperationsService taskOperationsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/add/{taskId}")
    public String addTaskOperations(Model model, HttpSession session, @PathVariable Long taskId) {
        model.addAttribute("taskId", taskId);
        taskOperationsService.addTaskOperationsGet(model, session);
        return "taskoperations/form";
    }

    @PostMapping("/add/{taskId}")
    public String addTaskOperations(
            @Valid TaskOperations taskOperations,
            BindingResult errors,
            HttpServletRequest request,
            @PathVariable Long taskId
    ) {
        if (errors.hasErrors()) {
            return "taskoperations/form";
        }
        taskOperationsService.addTaskOperationsPost(taskOperations);
        return "redirect:" + request.getContextPath() + "/task/list";
    }

    @GetMapping("/edit/{taskOperationsId}")
    public String editTaskOperations(Model model, @PathVariable Long taskOperationsId, HttpServletRequest request) {
        model.addAttribute("taskOperationsId", taskOperationsId);
        taskOperationsService.editTaskOperations(model, taskOperationsId);
        return "taskoperations/edit";
    }

    @PostMapping("/edit/{taskOperationsId}")
    public String editTaskOperations(
            @Valid TaskOperations taskOperations,
            BindingResult errors,
            HttpServletRequest request,
            @PathVariable Long taskOperationsId
    ) {
        if (errors.hasErrors()) {
            return "taskoperations/edit";
        }
        taskOperationsService.addTaskOperationsPost(taskOperations);
        return "redirect:" + request.getContextPath() + "/task/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTaskOperations(@PathVariable Long id, HttpServletRequest request) {
        taskOperationsService.deleteTaskOperations(id);
        return "redirect:" + request.getContextPath() + "/task/list";
    }

    @RequestMapping("/list")
    public String showAll(Model model) {
        taskOperationsService.showAll(model);
        return "taskoperations/list";
    }

    @ModelAttribute("taskoperations")
    public List<TaskOperations> taskOperationsList() {
        return taskOperationsRepository.findAll();
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }

    @ModelAttribute("tasks")
    public List<Task> tasks() {
        return taskRepository.findAll();
    }

}
