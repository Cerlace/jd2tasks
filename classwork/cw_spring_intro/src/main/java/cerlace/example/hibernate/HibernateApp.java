package cerlace.example.hibernate;

import cerlace.example.hibernate.dao.DAO;
import cerlace.example.hibernate.dao.impl.BaseDao;
import cerlace.example.hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class HibernateApp {
//    @Autowired
    DAO<Employee> employeeDAO = new BaseDao<>();


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        HibernateApp app = context.getBean(HibernateApp.class);

        Employee e = new Employee();
        e.setFirstName("Yulia");
        e.setLastName("Shasha");
        Employee save = app.employeeDAO.add(e);

        System.out.println(save);
    }
}
