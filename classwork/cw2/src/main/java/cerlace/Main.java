package cerlace;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        String URL = JDBCResources.getUrl();
        String login = JDBCResources.getUser();
        String password = JDBCResources.getPassword();

        String selectQuery = "SELECT * FROM cars_db.employees";

        String insertQuery = "INSERT INTO cars_db.employees(name, position, id_dept, salary)" +
                             "VALUES ('Афанасьев', 'Гендиректор', 1, 15000)";

        String deleteQuery = "DELETE FROM cars_db.employees WHERE salary > 10000";

        try (Connection conn = DriverManager.getConnection(URL, login, password);
             Statement statement = conn.createStatement()) {

            statement.executeUpdate(insertQuery);

            try(ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getString("name") + " " +
                                    resultSet.getString("position") + " " +
                                    resultSet.getInt("salary"));
                }
            }

            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
