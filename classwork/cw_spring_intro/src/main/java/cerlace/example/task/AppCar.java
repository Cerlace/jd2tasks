package cerlace.example.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCar {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        Car car = context.getBean("car", Car.class);
        System.out.println(car);
        car.getEngine().gas();
    }
}
