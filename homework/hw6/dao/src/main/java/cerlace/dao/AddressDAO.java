package cerlace.dao;

import cerlace.dto.Address;

import java.sql.SQLException;
/**
 * Интерфейс {@code AddressDAO} содержит методы для доступа к данным
 * базы данных Address.
 */
public interface AddressDAO extends DAO<Address> {
    /**
     * Метод увеличивает номер дома последних двух адресов в таблице на один (1).
     * @return результат операции.
     */
    boolean increaseHouseByOneForLastTwo() throws SQLException;
}
