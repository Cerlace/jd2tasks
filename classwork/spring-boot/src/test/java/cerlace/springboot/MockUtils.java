package cerlace.springboot;

import cerlace.springboot.entity.City;

import java.util.ArrayList;
import java.util.List;

import static cerlace.springboot.MockConstants.*;

public class MockUtils {

    public static List<City> createCities() {
        List<City> cityList = new ArrayList<>();
        cityList.add(creteCity(CITY_NAME_1));
        cityList.add(creteCity(CITY_NAME_2));
        return cityList;
    }

    private static City creteCity(String cityName) {
        return City.builder().name(cityName).build();
    }
}
