package cerlace;

import cerlace.entity.Department;
import cerlace.entity.Employee;
import cerlace.entity.EmployeeDetails;
import cerlace.entity.Meeting;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        EntityManager manager = HibernateUtil.getEntityManager();

        Meeting meeting = Meeting.builder()
                .meetingDate(new Date())
                .subject("Event")
                .build();

        EmployeeDetails details = EmployeeDetails.builder()
                .city("Minsk")
                .country("Belarus")
                .state("Minskaya")
                .street("Mavra")
                .build();

        Department department = Department.builder()
                .departmentName("DODO")
                .build();

        Employee employee = Employee.builder()
                .birthDate(new Date(100, 6, 13))
                .cellPhone(256574963)
                .firstName("Daniil")
                .lastName("Nesterov")
                .employeeDetails(details)
                .department(department)
                .meetings(Set.of(meeting))
                .build();

        details.setEmployee(employee);

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();
        manager.close();

        EntityManager manager1 = HibernateUtil.getEntityManager();

        Employee employeeFromDb = manager1.find(Employee.class, employee.getId());
        manager.close();

        System.out.println(employeeFromDb);
    }
}
