package cerlace.dao.impl;

import cerlace.dao.AddressDAO;
import cerlace.dto.Address;
import cerlace.util.SQLExecutor;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS address (" +
                    " id INT AUTO_INCREMENT PRIMARY KEY," +
                    " street VARCHAR(50) NOT NULL," +
                    " house INT NOT NULL;";
    private static final String INSERT_QUERY =
            "INSERT INTO address (street, house)" +
                    " VALUES (?, ?);";
    private static final String UPDATE_QUERY =
            "UPDATE address" +
                    " SET street = ?, house = ?" +
                    " WHERE id = ?;";
    private static final String DELETE_QUERY =
            "DELETE FROM address" +
                    " WHERE id = ?;";
    private static final String DELETE_FIRST_QUERY =
            "DELETE FROM address" +
                    " LIMIT 1;";
    private static final String SELECT_QUERY =
            "SELECT * FROM address" +
                    " WHERE id = ?;";
    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM address;";
    private static final String INCREASE_HOUSE_QUERY =
            "UPDATE address" +
                    " SET house = house + 1" +
                    " ORDER BY id DESC" +
                    " LIMIT 2;";

    @Override
    public void createTable() {
        SQLExecutor.executeSQL(CREATE_TABLE_QUERY, PreparedStatement::executeUpdate);
    }

    @Override
    public boolean save(Address address) {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(INSERT_QUERY, statement -> {
            statement.setString(1, address.getStreet());
            statement.setInt(2, address.getHouse());
            return statement.executeUpdate() > 0;
        }));
    }

    @Override
    public Address get(Serializable id) {
        return SQLExecutor.executeSQL(SELECT_QUERY, statement -> {
            statement.setInt(1, (Integer) id);
            return getRecordAsObject(statement);
        });
    }

    @Override
    public boolean update(Serializable id, Address address) {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(UPDATE_QUERY, statement -> {
            statement.setString(1, address.getStreet());
            statement.setInt(2, address.getHouse());
            statement.setInt(3, (Integer) id);
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
    public List<Address> getAll() {
        return SQLExecutor.executeSQL(SELECT_ALL_QUERY, AddressDAOImpl::getRecordsAsList);
    }

    @Override
    public boolean increaseHouseByOneForLastTwo() {
        return Boolean.TRUE.equals(SQLExecutor.executeSQL(INCREASE_HOUSE_QUERY,
                statement ->  statement.executeUpdate() > 0));
    }

    private static List<Address> getRecordsAsList(PreparedStatement statement) throws SQLException {
        List<Address> list = new ArrayList<>();
        try (ResultSet resultSet = statement.getResultSet()) {
            while (resultSet.next()) {
                list.add(new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("street"),
                        resultSet.getInt("house")));
            }
        }
        return list;
    }

    private static Address getRecordAsObject(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.getResultSet()) {
            resultSet.next();
            return new Address(
                    resultSet.getInt("id"),
                    resultSet.getString("street"),
                    resultSet.getInt("house"));
        }
    }
}
