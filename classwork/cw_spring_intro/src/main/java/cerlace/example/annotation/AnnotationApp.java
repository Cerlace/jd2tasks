package cerlace.example.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SecondConfig.class);
        context.getBean("personAnnotation", Person.class).introduce();
    }
}
