package cerlace.orm;

import cerlace.dto.Car;
import cerlace.dto.Shop;
import cerlace.orm.impl.CarDAO;
import cerlace.orm.impl.ShopDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Shop shop = new Shop(1, "Minsk");
        AbstractDAO<Shop> shopDAO = new ShopDAO();
        shopDAO.save(shop);

        Car car = new Car(1, "BMW", 70.5, "RED",
                1, 10000, 1);
        AbstractDAO<Car> carDAO = new CarDAO();
        carDAO.save(car);
    }
}
