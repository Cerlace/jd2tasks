package cerlace.pattern.builder;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static AnimalBuiler builer() {
        return new AnimalBuiler();
    }

    public static class AnimalBuiler {
        private String name;
        private int age;

        public AnimalBuiler(){
        }

        public AnimalBuiler name(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuiler age(int age) {
            this.age = age;
            return this;
        }

        public Animal build() {
            return new Animal(this.name, this.age);
        }
    }

    public static void main(String[] args) {
        Animal dog = Animal.builer()
                .age(23)
                .name("Dog")
                .build();

        System.out.println(dog);
    }
}
