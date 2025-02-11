package cerlace.example;

import cerlace.example.autowired.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

//        SenderService senderService = context.getBean("serviceSender", SenderService.class);
//        senderService.send("oOo");

        Person person = context.getBean("personAutowired", Person.class);
        if (person.getAddress() != null) {
            person.introduce();
        } else {
            System.out.println("No address");
        }
//
//        Person petr = context.getBean("person", Person.class);
//        Person yulia = context.getBean("person", Person.class);
//
//        petr.perform();
//        yulia.perform();


//
//        ConstructorBean constructorBean = context.getBean("constructorBean", ConstructorBean.class);
//
//        System.out.println(constructorBean.getName());
//        System.out.println(constructorBean.getStringList());
//        System.out.println(constructorBean.getMap().get(5L));
    }
}
