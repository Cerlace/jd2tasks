package cerlace.dao;

import cerlace.dto.People;

import java.sql.SQLException;
/**
 * Интерфейс {@code PeopleDAO} содержит методы для доступа к данным
 * базы данных People.
 */
public interface PeopleDAO extends DAO<People> {
    /**
     * Метод увеличивает возраст последних двух людей в таблице на два (2).
     * @return результат операции.
     */
    boolean increaseAgeByTwoForLastTwo() throws SQLException;
}
