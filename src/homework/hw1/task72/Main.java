package homework.hw1.task72;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        for(Method method: MyClass.class.getDeclaredMethods()) {
            System.out.printf("Method %s, annotated = %b", method.getName(), method.isAnnotationPresent(AcademyInfo.class));
            System.out.println();
        }
    }
}
