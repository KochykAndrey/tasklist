package by.kochyk.tasklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EnableCaching
public class TasklistApplication {

    public static void main(final String[] args) {
        SpringApplication.run(TasklistApplication.class, args);
    }

}
