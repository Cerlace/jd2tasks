package cerlace.hibernate;

import cerlace.dto.entity.City;
import cerlace.dto.entity.Wheel;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {

        City city = City.builder()
                .name("Париж")
                .build();

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(city);

        EntityManager entityManager2 = HibernateUtil.getEntityManager();
        City cityEntity = entityManager2.find(City.class, 1);
        System.out.println(cityEntity);
        entityManager.close();
    }
}
