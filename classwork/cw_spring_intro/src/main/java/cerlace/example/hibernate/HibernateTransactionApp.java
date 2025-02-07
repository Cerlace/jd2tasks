package cerlace.example.hibernate;

import cerlace.example.hibernate.entity.Employee;
import cerlace.example.hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HibernateTransactionApp {
    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        HibernateTransactionApp app = context.getBean(HibernateTransactionApp.class);

        Employee e = new Employee();
        e.setFirstName("Yulia");
        e.setLastName("Yuliasha");
        Employee save = app.employeeService.add(e);

        System.out.println(save);
    }
}
