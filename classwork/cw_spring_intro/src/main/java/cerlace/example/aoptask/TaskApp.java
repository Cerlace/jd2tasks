package cerlace.example.aoptask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cerlace.example.aoptask")
public class TaskApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(TaskApp.class);
        context.refresh();
        context.start();

        HrService service = context.getBean(HrService.class);
        service.findEmployee("25 years");
    }
}
