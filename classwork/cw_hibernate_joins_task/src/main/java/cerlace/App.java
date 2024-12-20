package cerlace;


import cerlace.entity.Address;
import cerlace.entity.Apartment;
import cerlace.entity.Passport;
import cerlace.entity.People;

import javax.persistence.EntityManager;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        EntityManager manager = HibernateUtil.getEntityManager();

        Address address = Address.builder()
                .street("Пушкина")
                .house(7)
                .build();

        Apartment apartment1 = Apartment.builder()
                .floor(4)
                .address(address)
                .build();

        Apartment apartment2 = Apartment.builder()
                .floor(6)
                .address(address)
                .build();

        Passport passport1 = Passport.builder()
                .serial("MP")
                .number(123456)
                .build();


        People people1 = People.builder()
                .firstName("Иван")
                .middleName("Иванович")
                .lastName("Иванов")
                .passport(passport1)
                .apartments(Set.of(apartment1, apartment2))
                .build();

        passport1.setPeople(people1);

        People people2 = People.builder()
                .firstName("Андрей")
                .middleName("Андреевич")
                .lastName("Андреев")
                .apartments(Set.of(apartment1))
                .build();


        manager.getTransaction().begin();
        manager.persist(apartment1);
        manager.persist(apartment2);
        manager.getTransaction().commit();
        manager.close();

    }
}
