package cerlace.orm;

import cerlace.JDBCResources;
import cerlace.orm.annotations.Column;
import cerlace.orm.annotations.Id;
import cerlace.orm.annotations.Table;
import cerlace.dao.DAO;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UniversalDAO<T> implements DAO<T> {

    @Override
    public T save(T t) throws SQLException {
        String tableName = t.getClass().getAnnotation(Table.class).name();

        String query = String.format("INSERT INTO %s SET ", tableName) + getColumnsValues(t);

        executeSQL(query, PreparedStatement::executeUpdate);

        return t;
    }

    @Override
    public T get(Serializable id) throws SQLException {

        return null;
    }

    @Override
    public void update(T t) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }

    protected static <T> T executeSQL(String sql, SQLOperation<T> operation) {
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

    private String getColumnsValues(T t) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    continue;
                }
                field.setAccessible(true);
                String name = field.getAnnotation(Column.class).name();
                String value;
                Object object = field.get(t);
                if (object instanceof Number) {
                    value = object.toString();
                } else {
                    value = String.format("'%s'", object.toString());
                }
                sb.append(name + "=" + value + ", ");
            }
            sb.replace(sb.lastIndexOf(", "), sb.length(), ";");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
