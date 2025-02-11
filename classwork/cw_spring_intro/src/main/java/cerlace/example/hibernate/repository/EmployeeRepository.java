package cerlace.example.hibernate.repository;

import cerlace.example.hibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
