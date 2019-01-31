package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import taskmanager.repository.TaskOperationsRepository;


@Controller
@RequestMapping("/taskOperations")
public class TaskOperationsController {

    @Autowired
    private TaskOperationsRepository taskOperationsRepository;

    //TODO
}
