package cerlace;

import cerlace.entity.inheritence.joined.EmployeeJoined;
import cerlace.entity.inheritence.joined.PersonJoined;
import cerlace.entity.inheritence.joined.StudentJoined;
import cerlace.entity.inheritence.perclass.EmployeePerClass;
import cerlace.entity.inheritence.perclass.PersonPerClass;
import cerlace.entity.inheritence.perclass.StudentPerClass;
import cerlace.entity.inheritence.singletable.EmployeeSingle;
import cerlace.entity.inheritence.singletable.PersonSingle;
import cerlace.entity.inheritence.singletable.StudentSingle;

import javax.persistence.EntityManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManager manager = HibernateUtil.getEntityManager();

        PersonPerClass person = PersonPerClass.builder()
                .name("PersonName1")
                .surname("PersonSurname1")
                .build();
        EmployeePerClass employee = EmployeePerClass.builder()
                .name("EmployeeName1")
                .surname("EmployeeSurname1")
                .company("А100")
                .salary(1423.34)
                .build();
        StudentPerClass student = StudentPerClass.builder()
                .name("StudentName1")
                .surname("StudentSurname1")
                .faculty("Мехмат")
                .mark(9.4)
                .build();

        manager.getTransaction().begin();
        manager.persist(person);
        manager.persist(employee);
        manager.persist(student);
        manager.getTransaction().commit();

//        Company company = Company.builder()
//                .name("Европочта")
//                .homeAddress(Address.builder()
//                        .city("Москва")
//                        .street("Ленина")
//                        .zipcode(123456)
//                        .build())
//                .billingAddress(Address.builder()
//                        .city("Минск")
//                        .street("Победителей")
//                        .zipcode(220000)
//                        .build())
//                .build();
//
//        manager.getTransaction().begin();
//        manager.persist(company);
//        manager.getTransaction().commit();
    }
}
