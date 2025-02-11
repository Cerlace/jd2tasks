package cerlace.example.annotation;

import cerlace.example.autowired.IAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Component(value = "personAnnotation")
public class Person {
    //    @Value("#{'1'}")
    private String id;
    //    @Value("#{'Ivan'}")
    private String name;
    //    @Value("#{'Ivanov'}")
    private String surname;
    @Autowired
    private IAddress address;

    public void introduce() {
        System.out.println("Hello, I am " + surname + " " + name +
                " i live in " + address);
    }
}

