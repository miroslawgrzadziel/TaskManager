package taskmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import taskmanager.entity.User;
import taskmanager.repository.TaskRepository;

public class TaskConverter implements Converter<String, User> {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public User convert(String s) {
        return taskRepository.findOne(Long.parseLong(s));
    }
}
