package cerlace.orm;

import cerlace.dto.Car;
import cerlace.dto.Shop;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Shop shop = new Shop(1, "Minsk");
        UniversalDAO<Shop> shopDAO = new UniversalDAO<>();
        shopDAO.save(shop);

        Car car = new Car(1, "BMW", 70.5, "RED",
                1, 10000, 1);
        UniversalDAO<Car> carDAO = new UniversalDAO<>();
        carDAO.save(car);
    }
}
