package cerlace.dto;

/**
 * Класс {@code Address} является DTO для таблицы Address.
 * Поля соответствуют колонкам в таблице.
 */
public class Address {
    private int id;
    private String street;
    private int house;

    public Address() {
    }

    public Address(int id, String street, int house) {
        this.id = id;
        this.street = street;
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }
}
