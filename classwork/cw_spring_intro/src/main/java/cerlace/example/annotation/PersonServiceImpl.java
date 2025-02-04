package cerlace.example.annotation;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Override
    public Person getPerson() {
        return Person.builder()
                .id("6")
                .name("PersonService")
                .surname("SurnamePersonService")
                .build();
    }
}
