package taskmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import taskmanager.entity.User;
import taskmanager.repository.TaskOperationsRepository;

public class TaskOperationsConverter implements Converter<String, User> {

    @Autowired
    private TaskOperationsRepository taskOperationsRepository;

    @Override
    public User convert(String s) {
        return taskOperationsRepository.findOne(Long.parseLong(s));
    }
}
