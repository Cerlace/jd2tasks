package cerlace.example.hibernate.dao.impl;

import cerlace.example.hibernate.entity.Employee;
import cerlace.example.hibernate.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;

@ContextConfiguration("classpath:SpringConfig.xml")

@RunWith(SpringJUnit4ClassRunner.class)

public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void findAll() {
        Employee e = new Employee();
        e.setFirstName("Yulia");
        e.setLastName("Slabko");
        employeeRepository.save(e);
        assertFalse(employeeRepository.findAll().isEmpty());
        assertFalse(employeeRepository.findByFirstNameAndLastName("Yulia", "Slabko").isEmpty());
    }
}