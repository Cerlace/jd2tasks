package cerlace;

import cerlace.dao.AddressDAO;
import cerlace.dao.PeopleDAO;
import cerlace.dao.impl.AddressDAOImpl;
import cerlace.dao.impl.PeopleDAOImpl;
import cerlace.dto.Address;
import cerlace.dto.People;
import cerlace.util.TableUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Address> addressList = new ArrayList<>();
    private static final List<People> peopleList = new ArrayList<>();

    public static void main(String[] args) throws SQLException {
        fillDTOLists();

        AddressDAO addressDAO = new AddressDAOImpl();

        PeopleDAO peopleDAO = new PeopleDAOImpl();

        addressDAO.createTable();
        peopleDAO.createTable();

        for(int i = 0; i < 5; i++) {
            addressDAO.save(addressList.get(i));

            peopleDAO.save(peopleList.get(i));
        }

        System.out.println("Состояние до изменения:");
        System.out.println(TableUtil.getAddressTable(addressDAO.getAll()));
        System.out.println(TableUtil.getPeopleTable(peopleDAO.getAll()));

        addressDAO.increaseHouseByOneForLastTwo();
        peopleDAO.increaseAgeByTwoForLastTwo();

        addressDAO.deleteFirst();
        peopleDAO.deleteFirst();

        System.out.println("Состояние после изменения:");
        System.out.println(TableUtil.getAddressTable(addressDAO.getAll()));
        System.out.println(TableUtil.getPeopleTable(peopleDAO.getAll()));
    }

    private static void fillDTOLists() {
        addressList.add(new Address(1, "Пушкина", 2));
        addressList.add(new Address(2, "Ленина", 4));
        addressList.add(new Address(3, "Чкалова", 5));
        addressList.add(new Address(4, "Дзержинского", 1));
        addressList.add(new Address(5, "Азгура", 3));

        peopleList.add(new People(1, "Саша", "Савчик", 18));
        peopleList.add(new People(2, "Лиза", "Лизун", 25));
        peopleList.add(new People(3, "Иван", "Иванов", 54));
        peopleList.add(new People(4, "Анна", "Анина", 19));
        peopleList.add(new People(5, "Никита", "Никифоров", 22));
    }
}
