package cerlace.example.autowired;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component(value = "personAutowired")
public class Person {
    private String id;
    private String name;
    private String surname;
    private IAddress address;

    @Autowired
    public Person(@Value(value = "1") String id,
                  @Value(value = "Ivan") String name,
                  @Value(value = "Ivanov") String surname,
                  @Qualifier(value = "address") IAddress address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
//        System.out.println("Constructor injection");
    }

    public void setAddress(IAddress address) {
        this.address = address;
//        System.out.println("Setter injection");
    }

    public void introduce() {
        System.out.println("Hello, I am " + surname + " " + name +
                " i live in " + address.getCity() + " city, on " + address.getStreet() +
                " street, house " + address.getHouse());
    }
}
