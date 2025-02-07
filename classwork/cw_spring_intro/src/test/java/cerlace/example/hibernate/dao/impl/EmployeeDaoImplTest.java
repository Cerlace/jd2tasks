package cerlace.example.hibernate.dao.impl;

import cerlace.example.hibernate.dao.IEmployeeDAO;
import cerlace.example.hibernate.entity.Employee;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:SpringConfig.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EmployeeDaoImplTest {
    @Autowired
    private IEmployeeDAO employeeDAO;


    @Test
    @Transactional
    @Rollback(value = false)
    public void addEmployee() {
        Employee e = new Employee();
        e.setFirstName("Yulia");
        e.setLastName("Slabko");
        Employee save = employeeDAO.add(e);

        assertNotNull(save.getId());

        save = employeeDAO.get(save.getId());

        assertEquals(e, save);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteEmployee() {
        employeeDAO.delete(1);
        assertNull(employeeDAO.get(1));
    }


}