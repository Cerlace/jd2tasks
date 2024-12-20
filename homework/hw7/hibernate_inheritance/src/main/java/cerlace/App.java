package cerlace;

import cerlace.entity.HomeTask;
import cerlace.entity.Task;
import cerlace.entity.WorkTask;
import cerlace.entity.embeded.Address;

import javax.persistence.EntityManager;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManager manager = HibernateUtil.getEntityManager();

        Task task = Task.builder()
                .name("Simple task")
                .description("Do something usual")
                .build();

        HomeTask homeTask = HomeTask.builder()
                .name("Home task")
                .description("Wash dishes")
                .startDate(new Date())
                .endDate(new Date())
                .address(Address.builder()
                        .city("Minsk")
                        .street("Pushkina")
                        .build())
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("Work task")
                .description("Apartment renovation")
                .cost(4670.45)
                .build();

        manager.getTransaction().begin();

        manager.persist(task);
        manager.persist(homeTask);
        manager.persist(workTask);

        manager.getTransaction().commit();
        manager.close();
        HibernateUtil.close();
    }
}
