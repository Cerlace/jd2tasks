package cerlace.hibernate;

import cerlace.dto.entity.City;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {

        EntityManager entityManager1 = HibernateUtil.getEntityManager();

        EntityManager entityManager2 = HibernateUtil.getEntityManager();

        Session session = entityManager1.unwrap(Session.class);
        Session session2 = entityManager2.unwrap(Session.class);

        City myCity = session.get(City.class, 2);

        System.out.println(myCity);

        City myCity2 = session2.get(City.class, 2);

        System.out.println(myCity2);

    }

    private static void persist(EntityManager entityManager, City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    private static City find(EntityManager entityManager, Object primaryKey) {
        City cityEntity = entityManager.find(City.class, primaryKey);
        System.out.println(cityEntity);
        return cityEntity;
    }
}
