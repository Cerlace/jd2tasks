package cerlace.example.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfig {

    @Bean("createSecondConfigPerson")
    public Person createPerson() {
        return Person.builder()
                .id("4")
                .name("Alesha")
                .surname("Prox")
                .build();
    }

    @Bean("addressAnnotation")
    public Address createAddress() {
        return Address.builder()
                .id("1")
                .city("Minsk")
                .street("Proletarskaya")
                .house("120")
                .build();
    }
}
