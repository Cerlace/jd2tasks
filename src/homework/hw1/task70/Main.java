package homework.hw1.task70;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        try {
            Main.class.getMethod("printClassInfo", Class.class).invoke(null, Man.class);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printClassInfo(Class clazz) {
        System.out.printf("Приватные поля класса %s:\n", clazz.getSimpleName());
        for (Field field: clazz.getDeclaredFields()) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.printf("Конструкторы класса %s:\n", clazz.getSimpleName());
        for (Constructor constructor: clazz.getConstructors()) {
            System.out.print(clazz.getSimpleName() + "(");
            for (Parameter parameter: constructor.getParameters()){
                System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName() + ", ");
            }
            System.out.print("\b\b)\n");
        }
        System.out.printf("Методы класса %s:\n", clazz.getSimpleName());
        for (Method method: clazz.getMethods()) {
            System.out.print(method.getReturnType().getSimpleName() + " " + method.getName() + "(");
            if (method.getParameterCount() > 0) {
                for (Parameter parameter: method.getParameters()){
                    System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName() + ", ");
                }
                System.out.print("\b\b)\n");
            } else {
                System.out.print(")\n");
            }
        }

    }
}
