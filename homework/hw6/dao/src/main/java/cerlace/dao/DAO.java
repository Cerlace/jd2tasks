package cerlace.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс {@code DAO<T>} содержит методы для доступа к данным
 * базы данных. В качестве параметра {@code T} устанавливается
 * объект типа DTO, соответствующий обслуживаемой таблице.
 */
public interface DAO<T> {
    /**
     * Метод для создания таблицы.
     */
    void createTable() throws SQLException;

    /**
     * Метод для сохранения данных в таблицу.
     *
     * @param t сохраняемый объект.
     * @return результат операции.
     */
    boolean save(T t) throws SQLException;

    /**
     * Метод для получения одного объекта из таблицы
     * по его идентификатору.
     *
     * @param id идентификатор записи;
     * @return объект типа {@code T}, полученный по идентификатору.
     */
    T get(Serializable id) throws SQLException;

    /**
     * Метод для обновления записи в таблице.
     *
     * @param id идентификатор записи;
     * @param t  обновленная версия объекта;
     * @return результат операции.
     */
    boolean update(Serializable id, T t) throws SQLException;

    /**
     * Метод для удаления записи из таблицы.
     *
     * @param id идентификатор записи;
     * @return результат операции.
     */
    boolean delete(Serializable id) throws SQLException;

    /**
     * Метод для удаления первой записи из таблицы.
     *
     * @return результат операции.
     */
    boolean deleteFirst() throws SQLException;

    /**
     * Метод для получения всех объектов из таблицы.
     *
     * @return {@code List<T>} содержащий все записи таблицы.
     */
    List<T> getAll() throws SQLException;
}
