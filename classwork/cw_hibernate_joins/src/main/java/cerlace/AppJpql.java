package cerlace;

import cerlace.entity.Department;
import cerlace.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AppJpql {
    public static void main(String[] args) {
        EntityManager manager = HibernateUtil.getEntityManager();

        String jpql1 = "select e from Employee e where e.firstName in(:name)";

        Query query1 = manager.createQuery(jpql1);

        query1.setParameter("name", List.of("Nick", "Daniil"));

        List<Employee> employees = query1.getResultList();

        System.out.println("Достали " + employees);

        manager.close();
        HibernateUtil.close();
    }
}
