package cerlace.dao;

import cerlace.dao.impl.CityDAOImpl;
import cerlace.dto.entity.City;

import java.sql.SQLException;

public class AppDao {
    public static void main(String[] args) {
        try {
            CityDAO cityDAO = new CityDAOImpl();

            System.out.println(cityDAO.getAll());

            cityDAO.update(City.builder()
                    .name("Киров")
                    .id(4)
                    .build());

            System.out.println(cityDAO.getAll());

            cityDAO.delete(5);

            System.out.println(cityDAO.getAll());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
