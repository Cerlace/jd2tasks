package cerlace.example.aopannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(NoXmlAopConfiguration.class);
        context.refresh();
        context.start();

        TaskService service = context.getBean(TaskService.class);

        service.performJob();

        service.performJob("AHAHHAHA");

        try {
            service.performExceptionJob();
        } catch (Throwable e) {
            System.out.println("exception!");
        }

        service.performJobAround();
    }
}
