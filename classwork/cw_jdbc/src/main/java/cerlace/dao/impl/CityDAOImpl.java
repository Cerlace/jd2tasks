package cerlace.dao.impl;

import cerlace.JDBCResources;
import cerlace.dao.CityDAO;
import cerlace.dao.SqlExecutor;
import cerlace.dto.entity.City;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public City save(City city) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO city(name) values (?)")) {
            statement.setString(1, city.getName());
            statement.executeUpdate();
        }
        return city;
    }

    @Override
    public City get(Serializable id) throws SQLException {
        City city = new City();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM city WHERE id = ?")) {
            statement.setInt(1, (Integer) id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    city.setId(resultSet.getInt("id"));
                    city.setName(resultSet.getString("name"));
                }
            }
        }
        return city;
    }

    @Override
    public void update(City city) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE city SET name = ? WHERE id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM city WHERE id = ?")) {
            statement.setInt(1, (Integer) id);
            return statement.executeUpdate();
        }
    }

    @Override
    public City getCityByName(String name) throws SQLException {
        City city = new City();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM city WHERE name = ?")) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    city.setId(resultSet.getInt("id"));
                    city.setName(resultSet.getString("name"));
                }
            }
        }
        return city;
    }

    @Override
    public List<City> getAll() throws SQLException {
        List<City> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM city")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City();
                    city.setId(resultSet.getInt("id"));
                    city.setName(resultSet.getString("name"));
                    list.add(city);
                }
            }
        }
        return list;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                JDBCResources.getUrl(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
    }

    private static void executeSql(SqlExecutor<PreparedStatement> executor, String sql) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getUrl(),
                JDBCResources.getUser(),
                JDBCResources.getPassword());
        PreparedStatement statement = connection.prepareStatement(sql)) {
            executor.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
