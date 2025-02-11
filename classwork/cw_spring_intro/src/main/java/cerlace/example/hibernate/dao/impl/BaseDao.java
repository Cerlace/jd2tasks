package cerlace.example.hibernate.dao.impl;

import cerlace.example.hibernate.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;


public class BaseDao<T> implements DAO<T> {

    Class<T> clazz;
    ThreadLocal<EntityManager> em = new ThreadLocal<>();


    private EntityManagerFactory factory;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T add(T t) {
        begin();
        getEntityManager().persist(t);
        commit();
        return t;
    }

    @Override
    public T get(Serializable id) {
        return getEntityManager().find(clazz, id);
    }

    @Override
    public T update(T t) {
        begin();
        getEntityManager().merge(t);
        commit();
        return t;
    }

    @Override
    public void delete(Serializable id) {
        begin();
        T t = getEntityManager().find(clazz, id);
        getEntityManager().remove(t);
        commit();
    }

    public EntityManager getEntityManager() {
        if (em.get() == null) {
            em.set(factory.createEntityManager());
        }
        return em.get();
    }

    public void begin() {
        getEntityManager().getTransaction().begin();
    }
    public void commit() {
        getEntityManager().getTransaction().commit();
    }
}
