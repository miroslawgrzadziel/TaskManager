package taskmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import taskmanager.entity.TaskOperations;
import taskmanager.repository.TaskOperationsRepository;

public class TaskOperationsConverter implements Converter<String, TaskOperations> {

    @Autowired
    private TaskOperationsRepository taskOperationsRepository;

    @Override
    public TaskOperations convert(String s) {
        return taskOperationsRepository.findOne(Long.parseLong(s));
    }
}
