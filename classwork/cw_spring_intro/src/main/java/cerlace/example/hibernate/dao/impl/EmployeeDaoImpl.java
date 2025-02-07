package cerlace.example.hibernate.dao.impl;

import cerlace.example.hibernate.dao.IEmployeeDAO;
import cerlace.example.hibernate.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends BaseTransactionDao<Employee> implements IEmployeeDAO {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }
}
