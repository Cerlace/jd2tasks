package cerlace.dao.impl;

import cerlace.dao.PeopleDAO;
import cerlace.dto.People;
import cerlace.util.SQLExecutor;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleDAOImpl implements PeopleDAO {
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS people (" +
                    " id INT AUTO_INCREMENT PRIMARY KEY," +
                    " name VARCHAR(50) NOT NULL," +
                    " surname VARCHAR(50) NOT NULL," +
                    " age INT NOT NULL);";
    private static final String INSERT_QUERY =
            "INSERT INTO people (name, surname, age)" +
                    " VALUES (?, ?, ?);";
    private static final String UPDATE_QUERY =
            "UPDATE people" +
                    " SET name = ?, surname = ?, age = ?" +
                    " WHERE id = ?;";
    private static final String DELETE_QUERY =
            "DELETE FROM people" +
                    " WHERE id = ?;";
    private static final String DELETE_FIRST_QUERY =
            "DELETE FROM people" +
                    " LIMIT 1;";
    private static final String SELECT_QUERY =
            "SELECT * FROM people" +
                    " WHERE id = ?;";
    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM people;";
    private static final String INCREASE_AGE_QUERY =
            "UPDATE people" +
                    " SET age = age + 2" +
                    " ORDER BY id DESC" +
                    " LIMIT 2;";

    @Override
    public void createTable() {
        SQLExecutor.executeSQL(CREATE_TABLE_QUERY, PreparedStatement::executeUpdate);
    }

    @Override
    public boolean save(People people) {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(INSERT_QUERY, statement -> {
            statement.setString(1, people.getName());
            statement.setString(2, people.getSurname());
            statement.setInt(3, people.getAge());
            return statement.executeUpdate() > 0;
        }));
    }

    @Override
    public People get(Serializable id) {
        return SQLExecutor.executeSQL(SELECT_QUERY, statement -> {
            statement.setInt(1, (Integer) id);
            return getRecordAsObject(statement);
        });
    }

    @Override
    public boolean update(Serializable id, People people) {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(UPDATE_QUERY, statement -> {
            statement.setString(1, people.getName());
            statement.setString(2, people.getSurname());
            statement.setInt(3, people.getAge());
            statement.setInt(4, (Integer) id);
            return statement.executeUpdate() > 0;
        }));
    }

    @Override
    public boolean delete(Serializable id) {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(DELETE_QUERY, statement -> {
            statement.setInt(1, (Integer) id);
            return statement.executeUpdate() > 0;
        }));
    }

    @Override
    public boolean deleteFirst() {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(DELETE_FIRST_QUERY,
                statement -> statement.executeUpdate() > 0));
    }

    @Override
    public List<People> getAll() {
        return SQLExecutor.executeSQL(SELECT_ALL_QUERY, PeopleDAOImpl::getRecordsAsList);
    }

    @Override
    public boolean increaseAgeByTwoForLastTwo() {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(INCREASE_AGE_QUERY,
                statement ->  statement.executeUpdate() > 0));
    }

    private static List<People> getRecordsAsList(PreparedStatement statement) throws SQLException {
        List<People> list = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                list.add(new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")));
            }
        }
        return list;
    }

    private static People getRecordAsObject(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            resultSet.next();
            return new People(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getInt("age"));
        }
    }
}
