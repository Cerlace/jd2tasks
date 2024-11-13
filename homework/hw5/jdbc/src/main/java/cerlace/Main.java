package cerlace;

import cerlace.dao.EmployeeDAO;
import cerlace.dao.impl.EmployeeDAOImpl;
import cerlace.dto.Department;
import cerlace.dto.Employee;
import cerlace.util.JDBCResources;
import cerlace.util.PagingUtil;

import java.sql.Date;

/**
 * Точка входа в приложение.
 * Выполняет основные функции, предусмотренные задачей.
 */
public class Main {
    public static void main(String[] args) {
        String url = JDBCResources.getUrl();
        String user = JDBCResources.getUser();
        String password = JDBCResources.getPassword();
        EmployeeDAO db = new EmployeeDAOImpl(url, user, password);

        PagingUtil.printEmployeesByPages(db.selectByDepartment(Department.MARKETING.toString()), 4);
    }

    public static void insertValues(EmployeeDAO db) {
        db.insert(new Employee(1, "Иван", "Иванов",
                "ivanivanov@gmail.com", Department.SALES.toString(),
                900.5, Date.valueOf("2022-09-17")));
        db.insert(new Employee(2, "Владислав", "Соловьев",
                "vladsol@gmail.com", Department.TESTING.toString(),
                1800.7, Date.valueOf("2021-04-25")));
        db.insert(new Employee(3, "Валерий", "Королев",
                "valkor@gmail.com", Department.DEVELOPMENT.toString(),
                2607.8, Date.valueOf("2023-06-06")));
        db.insert(new Employee(4, "Александр", "Александрович",
                "alexalex@gmail.com", Department.HUMAN_RESOURCES.toString(),
                1304.20, Date.valueOf("2010-05-25")));
        db.insert(new Employee(5, "Станислав", "Ярош",
                "stasyarosh@gmail.com", Department.MANAGЕMENT.toString(),
                2400.23, Date.valueOf("2014-02-23")));
        db.insert(new Employee(6, "Влада", "Королева",
                "vladakoroleva@gmail.com", Department.DEVELOPMENT.toString(),
                2745.73, Date.valueOf("2024-03-06")));
    }
}
