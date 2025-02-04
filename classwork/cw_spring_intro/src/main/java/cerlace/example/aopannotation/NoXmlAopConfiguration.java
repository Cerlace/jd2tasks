package cerlace.example.aopannotation;

import cerlace.example.annotation.Person;
import cerlace.example.annotation.SecondConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SecondConfig.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cerlace.example.aopannotation")
public class NoXmlAopConfiguration {

    @Bean("createPerson")
    public Person createPerson() {
        return Person.builder()
                .id("3")
                .name("Danya")
                .surname("Nest")
                .build();
    }
}
