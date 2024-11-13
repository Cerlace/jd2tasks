package cerlace.dao;

import java.util.List;

public interface DAO<T> {
    void createTable();

    void insert(T t);

    void update(T t);

    void delete(int id);

    T select(int id);

    List<T> selectAll();
}
