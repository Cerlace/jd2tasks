package cerlace.example.annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MainWithAnnotationConfig {

    private final PersonService personService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(NoXmlConfiguration.class);
        ctx.refresh();
        ctx.start();

        Person personAnnotation = ctx.getBean("personAnnotation", Person.class);
        personAnnotation.introduce();

        Person createPerson = ctx.getBean("createPerson", Person.class);
        createPerson.introduce();

        Person createSecondConfigPerson = ctx.getBean("createSecondConfigPerson", Person.class);
        createSecondConfigPerson.introduce();

        MainWithAnnotationConfig config = ctx.getBean(MainWithAnnotationConfig.class);
        config.personService.getPerson().introduce();
    }
}
