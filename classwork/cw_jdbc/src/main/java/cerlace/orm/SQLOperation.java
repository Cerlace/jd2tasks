package cerlace.orm;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Функциональный интерфейс {@code SQLOperation} позволяет определить операцию, которую
 * необходимо выполнить перед запуском SQL запроса, и для успешного его завершения.
 *
 * @param <T> определяет тип возвращаемого значения, задается при инициализации операции.
 */
@FunctionalInterface
public interface SQLOperation<T> {
    /**
     * Метод выполняет необходимые манипуляции над объектом {@code PreparedStatement}
     * для успешного выполнения SQL запроса.
     *
     * @param statement выражение, содержащее SQL запрос;
     * @return результат выполнения SQL запроса, тип которого определяется задачей.
     * @throws SQLException при ошибке выполнения запроса.
     */
    T execute(PreparedStatement statement) throws SQLException;
}
