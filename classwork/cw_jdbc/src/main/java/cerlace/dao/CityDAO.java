package cerlace.dao;

import cerlace.dto.entity.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO extends DAO<City> {
    City getCityByName(String name) throws SQLException;
    List<City> getAll() throws SQLException;
}
