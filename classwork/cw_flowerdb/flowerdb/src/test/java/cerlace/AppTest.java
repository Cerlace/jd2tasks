package cerlace;

import cerlace.entity.Flower;
import cerlace.utils.HibernateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

public class AppTest {
    @Test
    void selectTest() {
        EntityManager manager = HibernateUtil.getEntityManager();
        App.create(manager, Flower.builder()
                .age(1)
                .name("Роза")
                .build());
        Flower testFlower = App.select(manager, Flower.class, 1);
        Assertions.assertEquals("Роза", testFlower.getName());
    }
}
