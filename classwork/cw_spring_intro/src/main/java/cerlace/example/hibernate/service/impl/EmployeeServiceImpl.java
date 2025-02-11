package cerlace.example.hibernate.service.impl;

import cerlace.example.hibernate.dao.IEmployeeDAO;
import cerlace.example.hibernate.entity.Employee;
import cerlace.example.hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseTransactionService<Employee> implements EmployeeService {
    @Autowired
    public EmployeeServiceImpl(IEmployeeDAO baseDAO) {
        super(baseDAO);
    }
}
