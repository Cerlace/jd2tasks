package cerlace.example.hibernate.dao;

import java.io.Serializable;

public interface IDAO<T> {
    T add (T t);
    T get (Serializable id);
    T update(T t);
    void delete(Serializable id);
}
