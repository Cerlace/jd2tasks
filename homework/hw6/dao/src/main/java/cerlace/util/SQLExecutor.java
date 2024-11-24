package cerlace.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Класс {@code SQLExecutor} является утилитарным классом, который
 * содержит методы для выполнения SQL запросов.
 */
public class SQLExecutor {
    /**
     * Метод является оберткой для успешного выполнения SQL запроса.
     * Он открывает соединение с БД, закрывает его в случае возникновения ошибки
     * или в конце работы, и выполняет необходимые операции, переданные через параметр.
     *
     * @param sql       запрос для выполнения;
     * @param operation операции, необходимые для выполнения SQL запроса;
     * @param <T>       определяет тип возвращаемого значения, задается при инициализации операции.
     * @return результат операции типа {@code <T>}.
     */
    public static <T> T executeSQL(String sql, SQLOperation<T> operation) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getUrl(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
             PreparedStatement statement = connection.prepareStatement(sql)) {
            return operation.execute(statement);
        } catch (SQLException e) {
            System.out.println("Возникла ошибка при выполнении SQL запроса!\n" +
                    "Код ошибки: " + e.getSQLState() + "\n" +
                    e.getLocalizedMessage());
            return null;
        }
    }
}
