package cerlace;

import cerlace.entity.Flower;
import cerlace.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class App {
    public static void main(String[] args) {
        EntityManager manager = HibernateUtil.getEntityManager();

        Flower flower1 = Flower.builder()
                .name("Роза")
                .age(2)
                .build();

        Flower flower2 = Flower.builder()
                .name("Тюльпан")
                .age(1)
                .build();

        Flower flower3 = Flower.builder()
                .name("Гортензия")
                .age(5)
                .build();

        Flower flower4 = Flower.builder()
                .name("Орхидея")
                .age(7)
                .build();

        Flower flower5 = Flower.builder()
                .name("Пион")
                .age(4)
                .build();

        create(manager, flower1);
        create(manager, flower2);
        create(manager, flower3);
        create(manager, flower4);
        create(manager, flower5);

        select(manager, flower3.getClass(), flower3.getId());

        delete(manager, flower4);


        ////////////////////////////////////////////////////////////////////////


        Session session = manager.unwrap(Session.class);

        Flower flower01 = Flower.builder()
                .name("Роза_S")
                .age(2)
                .build();

        Flower flower02 = Flower.builder()
                .name("Тюльпан_S")
                .age(1)
                .build();

        Flower flower03 = Flower.builder()
                .name("Гортензия_S")
                .age(5)
                .build();

        Flower flower04 = Flower.builder()
                .name("Орхидея_S")
                .age(7)
                .build();

        Flower flower05 = Flower.builder()
                .name("Пион_S")
                .age(4)
                .build();

        createS(session, flower01);
        createS(session, flower02);
        createS(session, flower03);
        createS(session, flower04);
        createS(session, flower05);

        selectS(session, flower03.getClass(), flower03.getId());

        deleteS(session, flower04);
    }

    public static <T> void deleteS(Session session, T object) {
        session.getTransaction().begin();
        session.delete(object);
        session.getTransaction().commit();
        System.out.println("Удалил " + object + " через Session");
    }

    public static <T, E extends Serializable> T selectS(Session session, Class<T> clazz, E id) {
        T entity = session.get(clazz, id);
        System.out.println("Достал " + entity + " через Session");
        return entity;
    }

    public static <T> void createS(Session session, T object) {
        session.getTransaction().begin();
        session.save(object);
        session.getTransaction().commit();
        System.out.println("Добавил " + object + " через Session");
    }

    public static <T> void delete(EntityManager manager, T object) {
        manager.getTransaction().begin();
        manager.remove(object);
        manager.getTransaction().commit();
        System.out.println("Удалил " + object + " через EntityManager");
    }

    public static <T, E> T select(EntityManager manager, Class<T> clazz, E id) {
        T entity = manager.find(clazz, id);
        System.out.println("Достал " + entity + " через EntityManager");
        return entity;
    }

    public static <T> void create(EntityManager manager, T object) {
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        System.out.println("Добавил " + object + " через EntityManager");
    }
}
