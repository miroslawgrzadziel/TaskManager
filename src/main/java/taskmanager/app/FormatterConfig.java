package taskmanager.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import taskmanager.converter.TaskConverter;
import taskmanager.converter.TaskOperationsConverter;
import taskmanager.converter.UserConverter;
import taskmanager.repository.TaskOperationsRepository;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "taskmanager")
@EnableTransactionManagement
public class FormatterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getUserConverter());
        registry.addConverter(getTaskConverter());
        registry.addConverter(getTaskOperationsConverter());

    }

    @Bean
    public UserConverter getUserConverter() {
        return new UserConverter();
    }

    @Bean
    public TaskConverter getTaskConverter() { return  new TaskConverter(); }

    @Bean
    public TaskOperationsConverter getTaskOperationsConverter() { return new TaskOperationsConverter(); }
}
