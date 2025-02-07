package cerlace.example.hibernate.dao.impl;

import cerlace.example.hibernate.dao.IDAO;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

//@Repository
public class BaseTransactionDao<T> implements IDAO<T> {

    Class<T> clazz;

    @PersistenceContext
    @Getter
    EntityManager entityManager;

    public BaseTransactionDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T add(T t) {
        getEntityManager().persist(t);
        return t;
    }

    @Override
    public T get(Serializable id) {
        return getEntityManager().find(clazz, id);
    }

    @Override
    public T update(T t) {
        getEntityManager().merge(t);
        return t;
    }

    @Override
    public void delete(Serializable id) {
        T t = getEntityManager().find(clazz, id);
        getEntityManager().remove(t);
    }
}
