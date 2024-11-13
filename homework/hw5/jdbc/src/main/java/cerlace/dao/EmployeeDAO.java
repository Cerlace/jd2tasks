package cerlace.dao;

import cerlace.dto.Employee;

import java.util.List;

public interface EmployeeDAO extends DAO<Employee> {
    List<Employee> selectAllOrderBySalary();

    List<Employee> selectAllOrderByLastName();

    List<Employee> selectByDepartment(String department);

    List<Employee> selectBySalary(double salary);
}
