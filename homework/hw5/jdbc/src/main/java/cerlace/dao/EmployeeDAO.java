package cerlace.dao;

import cerlace.dto.Employee;

import java.util.List;

/**
 * Интерфейс {@code EmployeeDAO} содержит методы для доступа к данным
 * таблицы, хранящей объекты {@code Employee}.
 */
public interface EmployeeDAO extends DAO<Employee> {
    /**
     * Метод для получения всех объектов из таблицы,
     * отсортированных по полю {@code salary}.
     *
     * @return {@code List<Employee>} содержащий все записи таблицы,
     * отсортированные по условию.
     */
    List<Employee> selectAllOrderBySalary();

    /**
     * Метод для получения всех объектов из таблицы,
     * отсортированных по полю {@code last_name}.
     *
     * @return {@code List<Employee>} содержащий все записи таблицы,
     * отсортированные по условию.
     */
    List<Employee> selectAllOrderByLastName();

    /**
     * Метод для получения всех объектов из таблицы,
     * имеющих одинаковое значение {@code department}.
     *
     * @param department рабочий отдел, сотрудников которого необходимо выбрать;
     * @return {@code List<Employee>} содержащий все записи таблицы,
     * соответствующие условию.
     */
    List<Employee> selectByDepartment(String department);

    /**
     * Метод для получения всех объектов из таблицы,
     * имеющих значение {@code salary} выше заданного.
     *
     * @param salary минимальная зарплата для выбора;
     * @return {@code List<Employee>} содержащий все записи таблицы,
     * соответствующие условию.
     */
    List<Employee> selectBySalary(double salary);
}
