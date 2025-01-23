package cerlace.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    private static Person person = new Person();

    private String name;

    public static Person getInstance() {
        return person;
    }

    public void perform() {
        System.out.println("Hello " + name);
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
