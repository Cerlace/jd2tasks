package cerlace.dao.impl;

import cerlace.dao.EmployeeDAO;
import cerlace.dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code EmployeeDAOImpl} реализует интерфейс {@code EmployeeDAO},
 * содержит методы для доступа к данным таблицы,
 * хранящей объекты {@code Employee}.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS employees (" +
                    " id INT AUTO_INCREMENT PRIMARY KEY," +
                    " first_name VARCHAR(50) NOT NULL," +
                    " last_name VARCHAR(50) NOT NULL," +
                    " email VARCHAR(100), department VARCHAR(50)," +
                    " salary DECIMAL(10, 2), hire_date DATE);";
    private static final String INSERT_QUERY =
            "INSERT INTO employees (" +
                    " first_name, last_name, email," +
                    " department, salary, hire_date)" +
                    " VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_QUERY =
            "UPDATE employees" +
                    " SET first_name = ?, last_name = ?, email = ?," +
                    " department = ?, salary = ?, hire_date = ?" +
                    " WHERE id = ?;";
    private static final String DELETE_QUERY =
            "DELETE FROM employees" +
                    " WHERE id = ?;";
    private static final String SELECT_QUERY =
            "SELECT * FROM employees" +
                    " WHERE id = ?;";
    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM employees;";
    private static final String SELECT_BY_DEPARTMENT_QUERY =
            "SELECT * FROM employees" +
                    " WHERE department = ?;";
    private static final String SELECT_BY_SALARY_QUERY =
            "SELECT * FROM employees" +
                    " WHERE salary > ?;";
    private static final String SELECT_ALL_ORDER_BY_SALARY_QUERY =
            "SELECT * FROM employees" +
                    " ORDER BY salary;";
    private static final String SELECT_ALL_ORDER_BY_LAST_NAME_QUERY =
            "SELECT * FROM employees" +
                    " ORDER BY last_name;";
    private final String url;
    private final String user;
    private final String password;

    /**
     * Конструктор объекта, устанавливает поля для доступа
     * к обслуживаемой базе данных.
     *
     * @param url      путь к базе данных;
     * @param user     логин для доступа к БД;
     * @param password пароль для доступа к БД.
     */
    public EmployeeDAOImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void createTable() {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_QUERY)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
        }
    }

    public void insert(Employee employee) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            setEmployeeParams(statement, employee);
            if (statement.executeUpdate() == 1) {
                System.out.println("Данные успешно добавлены!");
            }
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
        }

    }

    public void update(Employee employee) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);

        ) {
            setEmployeeParams(statement, employee);
            statement.setInt(7, employee.getId());
            if (statement.executeUpdate() == 1) {
                System.out.println("Данные успешно обновлены!");
            }

        } catch (SQLException e) {
            printSQLExceptionMessage(e);
        }

    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            if (statement.executeUpdate() == 1) {
                System.out.println("Данные успешно удалены!");
            }
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
        }

    }

    public Employee select(int id) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return getRecordsAsList(resultSet).get(0);
            }
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
            return null;
        }
    }

    public List<Employee> selectAll() {
        return selectAllSupplier(SELECT_ALL_QUERY);
    }

    public List<Employee> selectAllOrderBySalary() {
        return selectAllSupplier(SELECT_ALL_ORDER_BY_SALARY_QUERY);
    }

    public List<Employee> selectAllOrderByLastName() {
        return selectAllSupplier(SELECT_ALL_ORDER_BY_LAST_NAME_QUERY);
    }

    public List<Employee> selectByDepartment(String department) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_DEPARTMENT_QUERY)) {
            statement.setString(1, department);
            try (ResultSet resultSet = statement.executeQuery()) {
                return getRecordsAsList(resultSet);
            }
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
            return new ArrayList<>();
        }
    }

    public List<Employee> selectBySalary(double salary) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_SALARY_QUERY)) {
            statement.setDouble(1, salary);
            try (ResultSet resultSet = statement.executeQuery()) {
                return getRecordsAsList(resultSet);
            }
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
            return new ArrayList<>();
        }
    }

    /**
     * Метод для обеспечения работы методов множественного выбора.
     *
     * @param selectAllQuery SQL-запрос, выполняемый в методе;
     * @return {@code List<Employee>} содержащий все записи таблицы,
     * соответствующие условию.
     */
    private List<Employee> selectAllSupplier(String selectAllQuery) {
        try (Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement statement = connection.prepareStatement(selectAllQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                return getRecordsAsList(resultSet);
            }
        } catch (SQLException e) {
            printSQLExceptionMessage(e);
            return new ArrayList<>();
        }
    }

    /**
     * Метод, устанавливающий в выражение {@code PreparedStatement} поля
     * объекта {@code Employee}.
     *
     * @param statement обслуживаемое выражение;
     * @param employee  объект, поля которого передаются в запрос;
     * @throws SQLException при возникновении ошибке в запросе.
     */
    private void setEmployeeParams(PreparedStatement statement, Employee employee) throws SQLException {
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getEmail());
        statement.setString(4, employee.getDepartment());
        statement.setDouble(5, employee.getSalary());
        statement.setDate(6, employee.getHireDate());
    }

    /**
     * Метод, собирающий записи из запроса множественного выбора
     * в {@code List}.
     *
     * @param resultSet результат множественного выбора;
     * @return {@code List<Employee>} содержащий все записи таблицы,
     * соответствующие условию.
     * @throws SQLException при возникновении ошибке в запросе.
     */
    private List<Employee> getRecordsAsList(ResultSet resultSet) throws SQLException {
        List<Employee> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("department"),
                    resultSet.getDouble("salary"),
                    resultSet.getDate("hire_date")));
        }
        return list;
    }

    /**
     * Метод выводит информацию о полученном {@code SQLException}
     * в удобном виде в консоль.
     *
     * @param e объект полученного исключения.
     */
    private void printSQLExceptionMessage(SQLException e) {
        System.out.println("Возникла ошибка при выполнении SQL запроса!\n" +
                "Код ошибки: " + e.getSQLState() + "\n" +
                e.getLocalizedMessage());
    }
}
