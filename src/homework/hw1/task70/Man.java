package homework.hw1.task70;

public class Man {
    private String firstName;
    private String lastName;
    private int age;

    public Man(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Man(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }
    public void sayFullName() {
        System.out.printf("My name is %s %s.\n", firstName, lastName);
    }

    public void sayAge() {
        System.out.printf("I am %d years old.\n", age);
    }
}
