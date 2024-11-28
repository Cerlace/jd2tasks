package cerlace.hibernate;

import cerlace.dto.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {

        EntityManager entityManager1 = HibernateUtil.getEntityManager();

        Session session = entityManager1.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();

        City myCity = session.get(City.class, 20);
        City newCity = session.load(City.class, 20);
        System.out.println(myCity);
        System.out.println(newCity);

        transaction.commit();
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
