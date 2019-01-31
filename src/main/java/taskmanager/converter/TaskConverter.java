package taskmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import taskmanager.entity.Task;
import taskmanager.repository.TaskRepository;

public class TaskConverter implements Converter<String, Task> {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task convert(String s) {
        return taskRepository.findOne(Long.parseLong(s));
    }
}
