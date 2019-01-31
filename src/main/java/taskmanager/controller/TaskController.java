package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import taskmanager.repository.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //TODO reszta i dodatkowe wstrzyknięcia
}
