package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import taskmanager.entity.Task;
import taskmanager.repository.TaskRepository;
import taskmanager.services.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    @GetMapping("/add")
    public String addTask(Model model, HttpSession session){
        taskService.addTaskGet(model,session);
        return "task/form";
    }

    @PostMapping("/add")
    public String addTask(@Valid Task task, BindingResult errors, HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "task/form";
        }
        taskService.addTaskPost(task);
        return "redirect:" +request.getContextPath()+ "/task/list";
    }

    @GetMapping("/edit/{id}")
    private String editTask(Model model, @PathVariable Long id){
        taskService.editTask(model,id);
        return "task/form";
    }

    @GetMapping("/delete/{id}")
    private String deleteTask(@PathVariable Long id, HttpServletRequest request){
        taskService.deleteTask(id);
        return "redirect:" +request.getContextPath()+ "/task/list";
    }

    @RequestMapping("/list")
    public String showAll(Model model) {
        taskService.showAll(model);
        return "task/list";
    }

    @ModelAttribute("tasks")
    public List<Task> taskList(){
        return taskRepository.findAll();
    }
}
