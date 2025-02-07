package cerlace.example.hibernate.service;

import java.io.Serializable;

public interface IService<T> {
    T add (T t);
    T get (Serializable id);
    T update(T t);
    void delete(Serializable id);
}
