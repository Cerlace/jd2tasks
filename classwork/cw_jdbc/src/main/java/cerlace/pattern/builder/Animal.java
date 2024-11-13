package cerlace.pattern.builder;

public class Animal {
    private String name;
    private int age;
    private String color;
    private boolean isMale;

    public Animal(String name, int age, String color, boolean isMale) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", isMale=" + isMale +
                '}';
    }

    public static AnimalBuiler builer() {
        return new AnimalBuiler();
    }

    public static class AnimalBuiler {
        private String name;
        private int age;
        private String color;
        private boolean isMale;

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

        public AnimalBuiler color(String color) {
            this.color = color;
            return this;
        }

        public AnimalBuiler isMale(boolean isMale) {
            this.isMale = isMale;
            return this;
        }

        public Animal build() {
            return new Animal(this.name, this.age, this.color, this.isMale);
        }
    }

    public static void main(String[] args) {
        Animal dog = Animal.builer()
                .age(23)
                .name("Dog")
                .color("Brown")
                .isMale(true)
                .build();

        System.out.println(dog);
    }
}
